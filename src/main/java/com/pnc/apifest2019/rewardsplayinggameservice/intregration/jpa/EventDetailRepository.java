package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetail, Long> {

    Optional<EventDetail> findByNameAndProductId(String name, long productId);
}
