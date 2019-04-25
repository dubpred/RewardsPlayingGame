package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById(long id);
}
