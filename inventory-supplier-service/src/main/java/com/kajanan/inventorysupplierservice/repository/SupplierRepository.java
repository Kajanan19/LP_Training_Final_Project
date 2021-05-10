package com.kajanan.inventorysupplierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorysupplierservice.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
