package com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

   // Optional<Product> findById(long id);
}
