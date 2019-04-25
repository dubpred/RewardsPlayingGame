package com.pnc.apifest2019.rewardsplayinggameservice.service;


public interface ItemService {

    Item createItemForNewUser(Product product, User user);

    Item validateAndGetItem(long itemId);
}

