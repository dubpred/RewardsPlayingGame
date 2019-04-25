package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.ProductRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.UserRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.UserDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ItemService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ItemService itemService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           final ProductRepository productRepository,
                           final ItemService itemService){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.itemService = itemService;
    }

    @Override
    public UserResponseDto createUser(UserDto userDto, long productId) {

        UserResponseDto userResponseDto = new UserResponseDto();

        //TODO: change structure, add checks
        productRepository.findById(productId).ifPresent(product -> {
            //create user and set basic properties
            System.out.println(product.getNumberOfTiers());
            User user = new User();
            user.init(userDto);

            //Create an initial item for a user
            Item item = itemService.createItemForNewUser(product, user);
            List<Item> items = new ArrayList<>();
            items.add(item);
            user.setItems(items);

            //TODO: add init for less method calls
            //TODO: work on response for a new user
            //save new user and create response structure
            User savedUser = userRepository.saveAndFlush(user);
            userResponseDto.setId(savedUser.getId());
            userResponseDto.setFirstName(savedUser.getFirstName());
            userResponseDto.setLastName(savedUser.getLastName());
            userResponseDto.setPointsBalance(savedUser.getPointsBalance());
//      userResponseDto.setItems(savedUser.getItems());
        });

        return userResponseDto;
    }
}
