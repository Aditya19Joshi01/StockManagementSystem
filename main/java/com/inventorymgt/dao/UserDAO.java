package com.inventorymgt.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymgt.dto.UserDTO;

public interface UserDAO extends JpaRepository<UserDTO, Long> {
	
	public UserDTO findByEmailAndPassword(String email, String password);
	public UserDTO findByEmail(String email);
	public UserDTO findById(long id);

}
