package com.pnc.apifest2019.rewardsplayinggameservice.service;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.CreateUserDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;

public interface UserService {

    UserResponseDto createUser(CreateUserDto createUserDto);

    User validateAndGetUser(long id);
/*
    UserItemResponseDto getDemoResponse(String lastName, String productName);
    */

}
