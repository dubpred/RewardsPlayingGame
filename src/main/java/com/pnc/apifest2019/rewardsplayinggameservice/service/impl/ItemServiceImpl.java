package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.ItemRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.User;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ItemService;
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