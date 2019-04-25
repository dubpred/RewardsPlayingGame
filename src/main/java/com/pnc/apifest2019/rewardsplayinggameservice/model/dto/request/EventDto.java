package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import javax.validation.constraints.NotNull;

public class EventDto {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
