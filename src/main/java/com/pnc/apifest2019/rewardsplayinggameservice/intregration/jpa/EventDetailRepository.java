package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.EventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetail, Long> {

    Optional<EventDetail> findByNameAndProductId(String name, long productId);
}
