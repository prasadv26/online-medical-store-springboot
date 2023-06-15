package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sunbeam.entities.OrderNew;

public interface OrderDao extends JpaRepository<OrderNew,Integer>{
	

}
