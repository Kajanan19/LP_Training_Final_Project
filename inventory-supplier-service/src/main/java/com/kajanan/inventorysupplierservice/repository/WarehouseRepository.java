package com.kajanan.inventorysupplierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorysupplierservice.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
