package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
