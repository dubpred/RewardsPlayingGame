package com.pnc.apifest2019.rewardsplayinggameservice.service;


import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.EventDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserItemResponseDto;

public interface TransactionService {

    UserItemResponseDto postTransaction(TransactionDto transactionDto);

    //UserItemResponseDto postEvent(long itemId, EventDto eventDto);
}
