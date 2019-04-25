package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.TransactionEarnRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionEarnRateRepository extends JpaRepository<TransactionEarnRate, Long> {

    List<TransactionEarnRate> findTransactionEarnRatesByProductId(long productId);

}
