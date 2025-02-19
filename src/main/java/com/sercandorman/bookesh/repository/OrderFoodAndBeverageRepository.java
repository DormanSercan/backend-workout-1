package com.sercandorman.bookesh.repository;

import com.sercandorman.bookesh.model.OrderFoodAndBeverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderFoodAndBeverageRepository extends JpaRepository<OrderFoodAndBeverage, Long> {
}
