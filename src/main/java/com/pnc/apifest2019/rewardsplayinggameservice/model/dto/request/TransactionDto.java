package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransactionDto {

    @NotNull
    private TransactionEarnRate.TransactionCatagory transactionCatagory;

    @NotNull
    private BigDecimal amount;

    public TransactionEarnRate.TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionEarnRate.TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
