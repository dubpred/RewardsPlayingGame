package com.pnc.apifest2019.rewardsplayinggameservice.service;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.CreateUserDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(CreateUserDto createUserDto);
/*
    UserItemResponseDto getDemoResponse(String lastName, String productName);
    */

}
