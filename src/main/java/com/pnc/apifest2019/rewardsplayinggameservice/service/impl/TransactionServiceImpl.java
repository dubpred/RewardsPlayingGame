package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.EventDetailRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.TransactionEarnRateRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.TransactionRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.XpEventRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.EventDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserItemResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.*;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ItemService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.InternationalFormatter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final ItemService itemService;
    private final TransactionEarnRateRepository transactionEarnRateRepository;
    private final TransactionRepository transactionRepository;
    private final EventDetailRepository eventDetailRepository;
    private final XpEventRepository xpEventRepository;

    @Autowired
    public TransactionServiceImpl(final ItemService itemService,
                                  final TransactionEarnRateRepository transactionEarnRateRepository,
                                  final TransactionRepository transactionRepository,
                                  final EventDetailRepository eventDetailRepository,
                                  final XpEventRepository xpEventRepository){
        this.itemService = itemService;
        this.transactionEarnRateRepository = transactionEarnRateRepository;
        this.transactionRepository = transactionRepository;
        this.eventDetailRepository = eventDetailRepository;
        this.xpEventRepository = xpEventRepository;
    }

    @Override
    @Transactional
    public UserItemResponseDto postTransaction(long itemId, TransactionDto transactionDto) {

        //Get the item if it exists
        Item item = itemService.validateAndGetItem(itemId);

        //Get all the TERs for the item's product
        /*
        List<TransactionEarnRate> transactionEarnRatesForProduct = transactionEarnRateRepository.findTransactionEarnRatesByProductId(item.getProduct().getId());
*/
        //Get all the transaction earn rates of the item's product
        //TODO: add a "validate and get" TER method

        //set the User's new point balance based on the transaction
        //TODO: fix warning

        //calculate if Level Up
 //       if(checkForLevelUp(item.getXpBalance(), item.getTier(), item.getProduct().getNumberOfTiers(), item.getProduct().getXpTierFormula()))



        //save the Transaction
        Transaction transaction = new Transaction();
        transaction.init(transactionDto);

        transactionRepository.saveAndFlush(transaction);

        //respond with the User-Item details
        return new UserItemResponseDto(item);
    }

    public UserItemResponseDto postEvent(long itemId, EventDto eventDto){

        //get the item or throw an exception if it doesn't exist
        Item item = itemService.validateAndGetItem(itemId);

        //get the event detail or throw an exception if it doesn't exist
        //EventDetail eventDetail = validateAndGetEventDetail(eventDto.getName(), item.getProduct().getId());

        //set new XP Balance

        //save new XP Event
        XpEvent xpEvent = new XpEvent();
        //xpEvent.setEventDetail(eventDetail);
        xpEventRepository.saveAndFlush(xpEvent);

        return new UserItemResponseDto(item);
    }

    //TODO: check on this math
    //TODO: This formula will round down (if transaction is for $50.76 -> will earn 50 xp), is this a problem for demo?
    private long calculateNewBalance(BigDecimal transactionAmount, BigDecimal earnRate, long oldBalance){
        //TODO: look up multiplying 2 longs
        long earnedAmount = earnRate.longValue() * transactionAmount.longValue();
        return oldBalance + earnedAmount;
    }
/*
    private EventDetail validateAndGetEventDetail(String name, long productId) {
        Optional<EventDetail> eventDetail = eventDetailRepository.findByNameAndProductId(name, productId);
        if (eventDetail.isPresent()) {
            return eventDetail.get();
        } else {
            throw new RuntimeException();
        }
    }
*/
    private boolean checkForLevelUp(int currentXp, int currentTier, int maxTier, String xpTierFormula){
        List<Integer> xpToLvlList = new ArrayList<Integer>();


        //depending on leveling Algorithm
            switch (xpTierFormula){
                case "Runescape":
                    for(int i = 0; i < maxTier; i++) {
                        xpToLvlList.add((int) (i + 300 * Math.pow(2, i / 7)) / 4);
                    }
                    break;
                case "Linear":
                    for(int i = 0; i < maxTier; i++) {
                        xpToLvlList.add(i * 250);
                    }
                    break;
            }



            //lower bound of current level
            int lower = xpToLvlList.get(currentTier);
            //upper bound of current level
            int upper = xpToLvlList.get(currentTier +1);

            //if current xp exceeds the upper limit of the current level you have leveled up
            if(currentXp>upper){
                return true;
            }else{
                return false;
            }



    }




}
