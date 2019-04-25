package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionEarnRateRepository extends JpaRepository<TransactionEarnRate, Long> {

    List<TransactionEarnRate> findTransactionEarnRatesByProductId(long productId);

}
