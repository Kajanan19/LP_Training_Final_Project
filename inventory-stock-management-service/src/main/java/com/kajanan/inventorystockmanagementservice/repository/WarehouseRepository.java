package com.kajanan.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorystockmanagementservice.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
	
}
