package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    //Optional<Item> findById(long id);
}
