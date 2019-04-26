package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

//TODO: Review all Validation Constraints
public class EventDetailDto {

    public EventDetailDto(){}

    private String name;

    @NotNull
    @Min(value = 1, message = "Must earn at least 1 xp point for per event")
    private long pointEarnAmount;

    @NotNull
    private long timeLimit;

    @NotNull
    private BigDecimal transactionTotal;

    @NotNull
    @Min(value = 1, message = "Must have a trigger of at least 1")
    private long occuranceTrigger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPointEarnAmount() {
        return pointEarnAmount;
    }

    public void setPointEarnAmount(long pointEarnAmount) {
        this.pointEarnAmount = pointEarnAmount;
    }

    public long getOccuranceTrigger() {
        return occuranceTrigger;
    }

    public void setOccuranceTrigger(long occuranceTrigger) {
        this.occuranceTrigger = occuranceTrigger;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public BigDecimal getTransactionTotal() {
        return transactionTotal;
    }

    public void setTransactionTotal(BigDecimal transactionTotal) {
        this.transactionTotal = transactionTotal;
    }
}