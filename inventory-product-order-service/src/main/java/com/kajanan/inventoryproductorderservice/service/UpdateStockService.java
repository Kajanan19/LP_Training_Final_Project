package com.kajanan.inventoryproductorderservice.service;

public interface UpdateStockService {

  boolean updateProductStock(Long productId, Double quantity);

}
