package com.kajanan.inventorysupplierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorysupplierservice.entity.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
