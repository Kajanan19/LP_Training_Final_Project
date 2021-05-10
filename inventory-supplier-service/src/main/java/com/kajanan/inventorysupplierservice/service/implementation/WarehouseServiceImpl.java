package com.kajanan.inventorysupplierservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.inventorysupplierservice.dto.WarehouseDto;
import com.kajanan.inventorysupplierservice.entity.Warehouse;
import com.kajanan.inventorysupplierservice.exception.NotFoundException;
import com.kajanan.inventorysupplierservice.helper.GenericMapper;
import com.kajanan.inventorysupplierservice.repository.WarehouseRepository;
import com.kajanan.inventorysupplierservice.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

  @Autowired
  private WarehouseRepository repository;

  @Override
  public Warehouse createWarehouse(WarehouseDto warehouse) {
    return repository.save(GenericMapper.warehouseDtoToEntity(warehouse));
  }

  @Override
  public List<Warehouse> getWarehouses() {
    return repository.findAll();
  }

  @Override
  public Warehouse fetchWarehouseById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("warehouseId", "Warehouse Not found"));
  }
  
}
