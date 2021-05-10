package com.kajanan.inventoryproductorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventoryproductorderservice.entity.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
  
}
