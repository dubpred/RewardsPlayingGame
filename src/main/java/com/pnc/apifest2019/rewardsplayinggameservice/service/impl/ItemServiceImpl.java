package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(final ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item createItemForNewUser(Product product, User user) {
        Item item = new Item();
        item.init();
        item.setProduct(product);
        item.setUser(user);
        return item;
    }

    //TODO: throw proper exception
    public Item validateAndGetItem(long itemId){
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            return item.get();
        }else{
            throw new RuntimeException();
        }
    }

}