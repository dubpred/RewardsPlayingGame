package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;

public class UserResponseDto {

    public UserResponseDto(){}

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.pointsBalance = user.getPointsBalance();
    }

    private long id;

    private String name;

    private long pointsBalance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public long getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(long pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

}
