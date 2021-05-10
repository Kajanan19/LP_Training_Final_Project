package com.kajanan.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.inventorystockmanagementservice.entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

}
