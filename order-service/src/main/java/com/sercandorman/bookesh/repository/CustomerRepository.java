package com.sercandorman.bookesh.repository;

import com.sercandorman.bookesh.model.Customer;
import com.sercandorman.bookesh.shared.Constants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, GenericRepository<Customer, Long> {

}