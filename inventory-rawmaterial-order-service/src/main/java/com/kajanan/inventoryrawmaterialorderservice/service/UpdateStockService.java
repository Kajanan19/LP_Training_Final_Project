package com.kajanan.inventoryrawmaterialorderservice.service;

public interface UpdateStockService {

  boolean updateProductStock(Long productId, Double quantity);

}
