package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.TransactionEarnRate;

import java.util.Date;

public class TransactionResponseDto {

  private TransactionEarnRate.TransactionCatagory transactionCatagory;

  private long amount;

  private Date postedDate;

  public TransactionResponseDto(TransactionEarnRate.TransactionCatagory transactionCatagory, long amount, Date postedDate){
    this.transactionCatagory = transactionCatagory;
    this.amount = amount;
    this.postedDate = postedDate;
  }

  public TransactionEarnRate.TransactionCatagory getTransactionCatagory() {
    return transactionCatagory;
  }

  public void setTransactionCatagory(TransactionEarnRate.TransactionCatagory transactionCatagory) {
    this.transactionCatagory = transactionCatagory;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }
}
