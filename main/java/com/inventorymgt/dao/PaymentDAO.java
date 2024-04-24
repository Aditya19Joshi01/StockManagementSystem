package com.inventorymgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymgt.dto.PaymentDTO;
import com.inventorymgt.dto.UserDTO;

public interface PaymentDAO extends JpaRepository<PaymentDTO, Long> {
	
	public PaymentDTO findById(long id);
	public List<PaymentDTO> findByEmail(String email);

}
