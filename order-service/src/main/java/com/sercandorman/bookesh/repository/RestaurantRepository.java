package com.sercandorman.bookesh.repository;

import com.sercandorman.bookesh.model.Restaurant;
import com.sercandorman.bookesh.shared.Constants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, GenericRepository<Restaurant, Long> {

}