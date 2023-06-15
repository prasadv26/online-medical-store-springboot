package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.OrderDetails;


public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}
