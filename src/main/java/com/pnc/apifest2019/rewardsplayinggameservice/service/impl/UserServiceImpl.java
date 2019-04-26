package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.ProductRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.UserRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.CreateUserDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ItemService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ProductService;
import com.pnc.apifest2019.rewardsplayinggameservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ItemService itemService;
    private final ProductService productService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           final ProductRepository productRepository,
                           final ItemService itemService,
                           final ProductService productService){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.itemService = itemService;
        this.productService = productService;
    }

    @Override
    @Transactional
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        //Create new user
        User user = new User();
        user.init(createUserDto);

        //set user items
        user.setItems(createUserDto
            .getProducts()
                .stream()
                    .map(p -> {
                        Item item = new Item();
                        Product product = productService.validateAndGetProduct(p);
                        item.setProduct(product);
                        item.setUser(user);
                        return item;
        }).collect(Collectors.toList()));

        User savedUser = userRepository.saveAndFlush(user);
        return new UserResponseDto(savedUser);
    }
/*
    @Override
    public UserItemResponseDto getDemoResponse(String lastName, String productName) {
        //get the user by last name
        User user = validateAndGetUser(lastName);

        //get the user's item of the specified product
        return null;
    }
*/
    public User validateAndGetUser(String name){
        Optional<User> user = userRepository.findByName(name);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException();
        }
    }


}
