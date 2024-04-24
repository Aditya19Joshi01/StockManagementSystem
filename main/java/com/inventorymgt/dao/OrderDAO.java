package com.inventorymgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymgt.dto.OrderDTO;



public interface OrderDAO extends JpaRepository<OrderDTO, Long> {

	public OrderDTO findById(long id);
	
	public List<OrderDTO> findByUserId(long id);
}
