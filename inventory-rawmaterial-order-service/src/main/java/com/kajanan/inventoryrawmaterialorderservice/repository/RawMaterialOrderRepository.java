package com.kajanan.inventoryrawmaterialorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajanan.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

@Repository
public interface RawMaterialOrderRepository extends JpaRepository<RawMaterialOrder, Long> {

}
