package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.TransactionEarnRate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransactionDto {

    @NotNull
    private String userName;

    @NotNull
    private String product;

    @NotNull
    private TransactionEarnRate.TransactionCatagory transactionCatagory;

    @NotNull
    private String vendor;

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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
