package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.TransactionRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.TransactionResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.*;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ProductService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.TransactionService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final ProductService productService;

    @Autowired
    public TransactionServiceImpl(final TransactionRepository transactionRepository,
                                  final UserService userService,
                                  final ProductService productService){
        this.transactionRepository = transactionRepository;
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
        transactionEarnRate.ifPresent(t -> {
                if(t.getPointEarnRate().doubleValue() > 0) {
                    user.setPointsBalance(calculateNewBalance
                        (transactionDto.getAmount(), t.getPointEarnRate(), user.getPointsBalance()));
                }
            }
        );

        //calculate and set the new points balance
        if(checkForLevelUp(user.getPointsBalance(), user.getTier())){
            user.setTier(user.getTier() + 1);
        }

        //Save transaction
        Transaction transaction = new Transaction();
        transaction.init(transactionDto);
        transaction.setUser(user);
        transaction.setProduct(product);
        if(transactionEarnRate.isPresent()){
            transaction.setPointAmount(transactionDto.getAmount().longValue() * transactionEarnRate.get().getPointEarnRate().longValue());
        }else{
            transaction.setPointAmount(transactionDto.getAmount().longValue());
        }
        Transaction savedTransaction = transactionRepository.saveAndFlush(transaction);

        return new TransactionResponseDto(transactionDto.getTransactionCatagory(), transaction.getPointAmount(), transaction.getPostedDate());
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
     private long calculateNewBalance(BigDecimal transactionAmount, BigDecimal earnRate, long oldBalance){
        double earnedAmount = earnRate.doubleValue() * transactionAmount.doubleValue();
        return oldBalance + (long)earnedAmount;
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

    public static long getPointsToNextTier(long currentAccPoints, long currentTeir){
        List<Long> xpToLvlList = new ArrayList<Long>();

        xpToLvlList.add((long)1000);
        xpToLvlList.add((long)2000);
        xpToLvlList.add((long)3000);
        xpToLvlList.add((long)4000);
        xpToLvlList.add((long)5000);

        //lower bound of current level
        long lower = xpToLvlList.get((int)currentTeir);
        //upper bound of current level
        long upper = xpToLvlList.get((int)currentTeir +1);

        return (upper - currentAccPoints);



    }


}
