package com.kajanan.inventorystockmanagementservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.inventorystockmanagementservice.entity.Product;
import com.kajanan.inventorystockmanagementservice.entity.ProductStockRequest;
import com.kajanan.inventorystockmanagementservice.entity.RawMaterial;
import com.kajanan.inventorystockmanagementservice.entity.RawMaterialStockRequest;
import com.kajanan.inventorystockmanagementservice.repository.ProductRepository;
import com.kajanan.inventorystockmanagementservice.repository.RawMaterialRepository;
import com.kajanan.inventorystockmanagementservice.service.StockManagementService;

@Service
public class StockManagementServiceImpl implements StockManagementService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RawMaterialRepository rawMaterialRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<RawMaterial> getAllRawMaterials() {
		return rawMaterialRepository.findAll();
	}

	@Override
	public RawMaterial getRawMaterialById(Long id) {
		return rawMaterialRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public RawMaterial saveRawMaterial(RawMaterial rawMaterial) {
		return rawMaterialRepository.save(rawMaterial);
	}

	@Override
	public Product updateProductStock(ProductStockRequest stock) {
		Product fetchedProduct = productRepository.findById(stock.getProductId()).orElseThrow(() -> new RuntimeException());
		fetchedProduct.setQuantityAvailable(fetchedProduct.getQuantityAvailable() + stock.getQuantity());
		return productRepository.save(fetchedProduct);
	}

	@Override
	public RawMaterial updateRawMaterialStock(RawMaterialStockRequest stock) {
		RawMaterial rawMaterial = rawMaterialRepository.findById(stock.getRawMaterialId())
				.orElseThrow(() -> new RuntimeException());
		rawMaterial.setQuantityAvailable(rawMaterial.getQuantityAvailable() + stock.getQuantity());
		return rawMaterialRepository.save(rawMaterial);
	}

}
