package com.inventorymgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventorymgt.dao.PaymentDAO;
import com.inventorymgt.dto.PaymentDTO;


@Service
public class PaymentService {
	
	@Autowired
	public PaymentDAO dao;
	
	public PaymentDTO Add(PaymentDTO dto) {
		PaymentDTO  payment = dao.save(dto);
       return  payment;
	}
	

	public List<PaymentDTO> list(){
		List<PaymentDTO> dto = dao.findAll();
		return dto;
	}
	
	public List<PaymentDTO> list(String email){
		List<PaymentDTO> dto = dao.findByEmail(email);
		return dto;
	}
	


}
