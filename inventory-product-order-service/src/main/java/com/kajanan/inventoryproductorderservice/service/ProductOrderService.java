package com.kajanan.inventoryproductorderservice.service;

import java.util.List;
import java.util.Map;

import com.kajanan.inventoryproductorderservice.dto.ProductOrderRequest;
import com.kajanan.inventoryproductorderservice.dto.ProductOrderResponse;
import com.kajanan.inventoryproductorderservice.dto.UpdateStatusDto;

public interface ProductOrderService {

	ProductOrderResponse fetchProductOrderById(long productOrderId);
	
	List<ProductOrderResponse> fetchAllProductOrders();
	
	ProductOrderResponse updateProductOrderDeliveryStatus(UpdateStatusDto updateStatusDto);
	
	Map<String, String> createProductOrder(ProductOrderRequest productOrder);
	
}
