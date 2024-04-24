package com.inventorymgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymgt.dto.CategoryDTO;

public interface CategoryDAO extends JpaRepository<CategoryDTO, Long>{
	
	public CategoryDTO findById(long id);
	public CategoryDTO findByName(String name);

}
