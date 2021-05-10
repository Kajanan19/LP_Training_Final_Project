package com.kajanan.inventoryrawmaterialorderservice.service;

import java.util.List;
import java.util.Map;

import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.kajanan.inventoryrawmaterialorderservice.dto.UpdateStatusDto;

public interface RawMaterialOrderService {

	//Create an RawMaterialOrder type of order to save in database
	Map<String, String> createRawMaterialOrder(RawMaterialOrderRequest orderRequest);
	
	//Update the Delivery status of the raw material ordered                       
	RawMaterialOrderResponse updateRawMaterialOrderDeliveryStatus(UpdateStatusDto updateStatusDto);
	
	//Find a particular Raw material order by its Id                                  
	RawMaterialOrderResponse fetchRawMaterialOrderById(Long id) ;
	
	//Fetch all Raw material orders
	List<RawMaterialOrderResponse> fetchAllOrders();
}
