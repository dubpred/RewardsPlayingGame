package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;

public class ItemResponseDto {

    private long id;

    private long tier;

    private long xpBalance;

    ItemResponseDto(Item item){
        this.id = item.getId();
        this.tier = item.getTier();
        this.xpBalance = item.getXpBalance();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
