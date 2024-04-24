package com.inventorymgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymgt.dto.ProductDTO;



public interface ProductDAO extends JpaRepository<ProductDTO, Long> {
	
	public ProductDTO findById(long id);
	//public ProductDTO findByCatId(long id);
	public ProductDTO findByName(String pName);
	public List<ProductDTO> findByCatId(long id);

}
