package com.pnc.apifest2019.rewardsplayinggameservice.service;


public interface TransactionService {

    UserItemResponseDto postTransaction(long itemId, TransactionDto transactionDto);

    UserItemResponseDto postEvent(long itemId, EventDto eventDto);
}
