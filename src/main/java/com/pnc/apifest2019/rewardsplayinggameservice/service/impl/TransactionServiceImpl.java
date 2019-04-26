package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.EventDetailRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.TransactionEarnRateRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.TransactionRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.XpEventRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.EventDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.TransactionResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserItemResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.*;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ItemService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ProductService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.TransactionService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.UserService;
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

    private final UserService userService;
    private final TransactionEarnRateRepository transactionEarnRateRepository;
    private final TransactionRepository transactionRepository;
    private final EventDetailRepository eventDetailRepository;
    private final XpEventRepository xpEventRepository;
    private final ProductService productService;

    @Autowired
    public TransactionServiceImpl(final TransactionEarnRateRepository transactionEarnRateRepository,
                                  final TransactionRepository transactionRepository,
                                  final EventDetailRepository eventDetailRepository,
                                  final XpEventRepository xpEventRepository,
                                  final UserService userService,
                                  final ProductService productService){
        this.transactionEarnRateRepository = transactionEarnRateRepository;
        this.transactionRepository = transactionRepository;
        this.eventDetailRepository = eventDetailRepository;
        this.xpEventRepository = xpEventRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    @Transactional
    public TransactionResponseDto postTransaction(TransactionDto transactionDto) {

        //Get the User if they exist
        User user = userService.validateAndGetUser(transactionDto.getId());
        //get product
        Product product = productService.validateAndGetProduct(transactionDto.getProduct());

        //get transaction earn rate for a product, tier, and transaction catagory
        Optional<TransactionEarnRate> transactionEarnRate = product
            .getTransactionEarnRates()
            .stream()
            .filter(ter -> transactionDto.getTransactionCatagory() == ter.getTransactionCatagory() && user.getTier() == ter.getTier())
            .findFirst();

        //get earn rate
        transactionEarnRate.ifPresent(t ->
            user.setPointsBalance(calculateNewBalance
                (transactionDto.getAmount(), t.getPointEarnRate(), user.getPointsBalance())));

        //calculate and set the new points balance
        if(checkForLevelUp(user.getPointsBalance(), user.getTier())){
            user.setTier(user.getTier() + 1);
        }

        //Save transaction
        Transaction transaction = new Transaction();
        transaction.init(transactionDto);
        transaction.setUser(user);
        Transaction savedTransaction = transactionRepository.saveAndFlush(transaction);

        return new TransactionResponseDto(transactionDto.getTransactionCatagory(), transactionDto.getAmount(), transaction.getPostedDate());
    }
/*
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
*/
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
    private boolean checkForLevelUp(long currentXp, long currentTier /*,int maxTier, String xpTierFormula*/){
        List<Long> xpToLvlList = new ArrayList<Long>();

        xpToLvlList.add((long)1000);
        xpToLvlList.add((long)2000);
        xpToLvlList.add((long)3000);
        xpToLvlList.add((long)4000);
        xpToLvlList.add((long)5000);

        //lower bound of current level
        long lower = xpToLvlList.get((int)currentTier);
        //upper bound of current level
        long upper = xpToLvlList.get((int)currentTier +1);

//        //depending on leveling Algorithm
//            switch (xpTierFormula){
//                case "Exponential":
//                    for(int i = 0; i < maxTier; i++) {
//                        xpToLvlList.add((long)1000);
//                        xpToLvlList.add((long)3000);
//                        xpToLvlList.add((long)9000);
//                        xpToLvlList.add((long)27000);
//                        xpToLvlList.add((long)100000);
//
//
//                    }
//                    break;
//                case "Linear":
//                    for(int i = 0; i < maxTier; i++) {
//                        xpToLvlList.add((long)i * 250);
//                    }
//                    break;
//            }



            //if current xp exceeds the upper limit of the current level you have leveled up
            if(currentXp>upper){
                return true;
            }else{
                return false;
            }
     }

    public static long getPointsToNextTier(int currentAccPoints, int currentTeir){
        List<Long> xpToLvlList = new ArrayList<Long>();

        xpToLvlList.add((long)1000);
        xpToLvlList.add((long)2000);
        xpToLvlList.add((long)3000);
        xpToLvlList.add((long)4000);
        xpToLvlList.add((long)5000);

        //lower bound of current level
        long lower = xpToLvlList.get(currentTeir);
        //upper bound of current level
        long upper = xpToLvlList.get(currentTeir +1);

        return (upper - currentAccPoints);



    }


}
