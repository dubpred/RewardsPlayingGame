package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import java.util.Date;

public class EventResponseDto {

  private String name;

  private long xpEarnAmount;

  private Date postedDate;

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

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }
}
