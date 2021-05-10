package com.kajanan.inventorysupplierservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class WarehouseDto {

	
	private Long warehouseId;

	@Size(min = 5, max = 40)
	@NotBlank
	private String name;

	@Size(min = 5, max = 100)
	@NotBlank
	private String description;

}
