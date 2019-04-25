package com.pnc.apifest2019.rewardsplayinggameservice.service;


import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;

public interface ItemService {

    Item createItemForNewUser(Product product, User user);

    Item validateAndGetItem(long itemId);
}

