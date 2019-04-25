package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;


import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;

public class UserItemResponseDto {

    public UserItemResponseDto(Item item){
        this.user = new UserResponseDto(item.getUser());
        this.item = new ItemResponseDto(item);
    }

    private UserResponseDto user;
    private ItemResponseDto item;

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto userResponseDto) {
        this.user = userResponseDto;
    }

    public ItemResponseDto getItem() {
        return item;
    }

    public void setItem(ItemResponseDto itemResponseDtos) {
        this.item = itemResponseDtos;
    }
}
