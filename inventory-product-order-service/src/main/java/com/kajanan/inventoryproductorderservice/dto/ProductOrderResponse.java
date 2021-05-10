package com.kajanan.inventoryproductorderservice.dto;

import java.time.LocalDate;

import com.kajanan.inventoryproductorderservice.entity.Warehouse;
import com.kajanan.inventoryproductorderservice.enums.MeasurementUnit;
import com.kajanan.inventoryproductorderservice.enums.OrderStatus;
import com.kajanan.inventoryproductorderservice.enums.QualityCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderResponse {

	private Long productOrderId;
	private Double quantity;
	private Double pricePerUnit;
	private QualityCheck qualityCheck;
	private OrderStatus orderStatus;
	private LocalDate deliveryDate;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private LocalDate orderedOn;
	private String distributorName;
	private Long distributorId;
	private String productName;
	private String description;
	private MeasurementUnit measurementUnit;
	private Warehouse warehouse;
	private Long productId;
}
