package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
