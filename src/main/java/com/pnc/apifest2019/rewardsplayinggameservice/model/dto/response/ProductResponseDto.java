package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;


//TODO: determine what all fields need to be returned
public class ProductResponseDto {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
