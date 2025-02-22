package com.sercandorman.bookesh.repository;

import com.sercandorman.bookesh.model.FoodAndBeverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAndBeverageRepository extends JpaRepository<FoodAndBeverage, Long>, GenericRepository<FoodAndBeverage, Long> {

}
