package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.XpEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XpEventRepository extends JpaRepository<XpEvent, Long> {
}
