package com.pnc.apifest2019.rewardsplayinggameservice.service;

public interface UserService {

    UserResponseDto createUser(UserDto userDto, long productId);
}
