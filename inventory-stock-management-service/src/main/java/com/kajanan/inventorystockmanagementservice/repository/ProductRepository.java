package com.kajanan.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorystockmanagementservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
