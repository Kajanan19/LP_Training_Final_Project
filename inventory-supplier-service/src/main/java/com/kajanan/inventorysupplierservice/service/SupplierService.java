package com.kajanan.inventorysupplierservice.service;

import java.util.List;

import com.kajanan.inventorysupplierservice.dto.SupplierDto;
import com.kajanan.inventorysupplierservice.entity.Supplier;

public interface SupplierService {
  Supplier addSupplier(SupplierDto supplier);

  List<Supplier> getSuppliers();

  Supplier getSupplierById(Long id);
}
