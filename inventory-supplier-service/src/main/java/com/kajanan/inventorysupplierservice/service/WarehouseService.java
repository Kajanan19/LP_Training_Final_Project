package com.kajanan.inventorysupplierservice.service;

import java.util.List;

import com.kajanan.inventorysupplierservice.dto.WarehouseDto;
import com.kajanan.inventorysupplierservice.entity.Warehouse;

public interface WarehouseService {

  Warehouse createWarehouse(WarehouseDto warehouse);

  List<Warehouse> getWarehouses();

  Warehouse fetchWarehouseById(Long id);

}
