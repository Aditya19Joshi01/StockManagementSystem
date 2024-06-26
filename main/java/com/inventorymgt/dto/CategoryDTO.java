package com.inventorymgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends BaseDTO {

	@Column(name = "name", length = 755)
	private String name;

	 @Column(name = "image", columnDefinition = "LONGBLOB")
	 private byte[] image;

}
