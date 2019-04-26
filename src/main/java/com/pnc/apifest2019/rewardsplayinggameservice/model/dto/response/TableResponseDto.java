package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import java.math.BigDecimal;

public class TableResponseDto {

  public TableResponseDto(String product, String transactionCatagory, String vendor, BigDecimal transactionAmount, long pointAmount){
    this.product = product;
    this.transactionCatagory = transactionCatagory;
    this.vendor = vendor;
    this.transactionAmount =transactionAmount;
    this.pointAmount = pointAmount;

  }
  private String product;
  private String transactionCatagory;
  private String vendor;
  private BigDecimal transactionAmount;
  private long pointAmount;

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getTransactionCatagory() {
    return transactionCatagory;
  }

  public void setTransactionCatagory(String transactionCatagory) {
    this.transactionCatagory = transactionCatagory;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public BigDecimal getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(BigDecimal transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public long getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(long pointAmount) {
    this.pointAmount = pointAmount;
  }
}
