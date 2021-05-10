package com.kajanan.inventorysupplierservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.inventorysupplierservice.dto.SupplierDto;
import com.kajanan.inventorysupplierservice.entity.Supplier;
import com.kajanan.inventorysupplierservice.exception.NotFoundException;
import com.kajanan.inventorysupplierservice.helper.GenericMapper;
import com.kajanan.inventorysupplierservice.repository.SupplierRepository;
import com.kajanan.inventorysupplierservice.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

  @Autowired
  private SupplierRepository repository;

  @Override
  public Supplier addSupplier(SupplierDto supplier) {
    return repository.save(GenericMapper.supplierDtoToEntity(supplier));
  }

  @Override
  public List<Supplier> getSuppliers() {
    return repository.findAll();
  }

  @Override
  public Supplier getSupplierById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("supplierId", "Supplier Not found"));
  }

}
