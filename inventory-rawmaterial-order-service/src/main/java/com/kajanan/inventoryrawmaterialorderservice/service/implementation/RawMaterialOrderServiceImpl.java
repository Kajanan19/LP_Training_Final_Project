package com.kajanan.inventoryrawmaterialorderservice.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.kajanan.inventoryrawmaterialorderservice.dto.UpdateStatusDto;
import com.kajanan.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.kajanan.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.kajanan.inventoryrawmaterialorderservice.exception.InvalidOrderUpdateStatusException;
import com.kajanan.inventoryrawmaterialorderservice.exception.RawMaterialNotFoundException;
import com.kajanan.inventoryrawmaterialorderservice.helper.RawMaterialMapper;
import com.kajanan.inventoryrawmaterialorderservice.repository.RawMaterialOrderRepository;
import com.kajanan.inventoryrawmaterialorderservice.service.RawMaterialOrderService;
import com.kajanan.inventoryrawmaterialorderservice.service.UpdateStockService;

@Service
public class RawMaterialOrderServiceImpl implements RawMaterialOrderService {

	@Autowired
	private RawMaterialOrderRepository repository;

	@Autowired
	private UpdateStockService updateStockService;

	// Create an RawMaterialOrder type of order to save in database
	public Map<String, String> createRawMaterialOrder(RawMaterialOrderRequest order) {
		return Collections.singletonMap("rawMaterialOrderId", repository.save(RawMaterialMapper.DtoToEntity(order)).getRawMaterialOrderId().toString());
	}

	// Update the Delivery status of the raw material ordered
	public RawMaterialOrderResponse updateRawMaterialOrderDeliveryStatus(UpdateStatusDto updateStatusDto) {
		RawMaterialOrder order = repository.findById(updateStatusDto.getOrderId()).orElseThrow(() -> new RawMaterialNotFoundException("rawMaterial", "Not found"));
		if(order.getOrderStatus().equals(OrderStatus.Delivered)) throw new InvalidOrderUpdateStatusException("status", "Product already delivered");
		if (order.getOrderStatus().equals(OrderStatus.Cancelled)) throw new InvalidOrderUpdateStatusException("status", "Product delivery was cancelled before");
		order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

		if (updateStatusDto.getStatus().equals(OrderStatus.Delivered.toString()))
			order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

		if (updateStockService.updateProductStock(order.getRawMaterial().getRawMaterialId(), order.getQuantity()))
		return RawMaterialMapper.entityToDto(this.repository.save(order));
		else throw new RuntimeException("Error Updating Quantity");
	}

	// Find a particular Raw material order by its Id
	public RawMaterialOrderResponse fetchRawMaterialOrderById(Long id) {
		return RawMaterialMapper.entityToDto(this.repository.findById(id).orElseThrow(() -> new RawMaterialNotFoundException("rawMaterial", "Not found")));
	}

	// Fetch all Raw material orders
	public List<RawMaterialOrderResponse> fetchAllOrders() {
		return this.repository.findAll().stream().map(RawMaterialMapper::entityToDto).collect(Collectors.toList());
	}
}
