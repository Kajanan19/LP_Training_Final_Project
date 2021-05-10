package com.kajanan.inventorystockmanagementservice.service;

import java.util.List;

import com.kajanan.inventorystockmanagementservice.entity.Product;
import com.kajanan.inventorystockmanagementservice.entity.ProductStockRequest;
import com.kajanan.inventorystockmanagementservice.entity.RawMaterial;
import com.kajanan.inventorystockmanagementservice.entity.RawMaterialStockRequest;

public interface StockManagementService {

  List<Product> getAllProducts() ;

	Product getProductById(Long id) ;

	List<RawMaterial> getAllRawMaterials() ;

	RawMaterial getRawMaterialById(Long id) ;

	Product saveProduct(Product product) ;

  RawMaterial saveRawMaterial(RawMaterial rawMaterial);
  
  Product updateProductStock(ProductStockRequest stockRequest);

  RawMaterial updateRawMaterialStock(RawMaterialStockRequest stockRequest);
}
