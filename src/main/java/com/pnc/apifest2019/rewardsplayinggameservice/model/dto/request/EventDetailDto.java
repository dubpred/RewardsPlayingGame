package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//TODO: Review all Validation Constraints
public class EventDetailDto {

    public EventDetailDto(){}

    @NotBlank(message = "Event detail must have a name")
    private String name;

    @NotNull
    @Min(value = 1, message = "Must earn at least 1 xp point for per event")
    private long xpEarnAmount;

    @NotNull
    @Min(value = 1, message = "Must have a trigger of at least 1")
    private long occuranceTrigger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getXpEarnAmount() {
        return xpEarnAmount;
    }

    public void setXpEarnAmount(long xpEarnAmount) {
        this.xpEarnAmount = xpEarnAmount;
    }

    public long getOccuranceTrigger() {
        return occuranceTrigger;
    }

    public void setOccuranceTrigger(long occuranceTrigger) {
        this.occuranceTrigger = occuranceTrigger;
    }
}