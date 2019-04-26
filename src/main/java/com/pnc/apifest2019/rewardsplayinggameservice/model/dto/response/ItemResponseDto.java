package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;

import java.util.List;

public class ItemResponseDto {

    private long tier;

    private long xpBalance;

    private List<TransactionResponseDto> transactions;

    private List<EventResponseDto> events;



    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public long getXpBalance() {
        return xpBalance;
    }

    public void setXpBalance(long xpBalance) {
        this.xpBalance = xpBalance;
    }

    public List<TransactionResponseDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionResponseDto> transactions) {
        this.transactions = transactions;
    }

    public List<EventResponseDto> getEvents() {
        return events;
    }

    public void setEvents(List<EventResponseDto> events) {
        this.events = events;
    }
}
