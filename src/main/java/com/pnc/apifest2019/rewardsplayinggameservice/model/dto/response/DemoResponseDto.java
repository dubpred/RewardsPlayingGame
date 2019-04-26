package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import java.util.List;

public class DemoResponseDto {

  private String name;

  private String pointsBalance;

  private long tier;

  private long pointToNextLevel;

  private List<TableResponseDto> table;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPointsBalance() {
    return pointsBalance;
  }

  public void setPointsBalance(String pointsBalance) {
    this.pointsBalance = pointsBalance;
  }

  public long getTier() {
    return tier;
  }

  public void setTier(long tier) {
    this.tier = tier;
  }

  public long getPointToNextLevel() {
    return pointToNextLevel;
  }

  public void setPointToNextLevel(long pointToNextLevel) {
    this.pointToNextLevel = pointToNextLevel;
  }

  public List<TableResponseDto> getTable() {
    return table;
  }

  public void setTable(List<TableResponseDto> table) {
    this.table = table;
  }
}
