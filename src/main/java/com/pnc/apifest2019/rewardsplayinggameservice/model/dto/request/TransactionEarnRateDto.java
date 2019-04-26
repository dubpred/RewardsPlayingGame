package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.TransactionEarnRate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

//TODO: Review all Validation Constraints
public class TransactionEarnRateDto {

    public TransactionEarnRateDto(){}

    @NotNull
    @Min(value = 1, message = "Tier must be at least 1")
    private long tier;

    //  @NotBlank(message = "Must specify a transaction catagory")
    //TODO: see if validation is needed
    private TransactionEarnRate.TransactionCatagory transactionCatagory;

    @NotNull
    @Min(value = 1, message = "Must have an earn rate of at least 1")
    private BigDecimal pointEarnRate;

    private long pointEarnAmounr;

    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public TransactionEarnRate.TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionEarnRate.TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }

    public BigDecimal getPointEarnRate() {
        return pointEarnRate;
    }

    public void setPointEarnRate(BigDecimal pointEarnRate) {
        this.pointEarnRate = pointEarnRate;
    }

    public long getPointEarnAmounr() {
        return pointEarnAmounr;
    }

    public void setPointEarnAmounr(long pointEarnAmounr) {
        this.pointEarnAmounr = pointEarnAmounr;
    }
}
