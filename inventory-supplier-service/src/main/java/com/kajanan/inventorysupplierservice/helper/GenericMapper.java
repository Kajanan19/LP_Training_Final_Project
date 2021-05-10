package com.kajanan.inventorysupplierservice.helper;

import com.kajanan.inventorysupplierservice.dto.DistributorDto;
import com.kajanan.inventorysupplierservice.dto.SupplierDto;
import com.kajanan.inventorysupplierservice.dto.WarehouseDto;
import com.kajanan.inventorysupplierservice.entity.Distributor;
import com.kajanan.inventorysupplierservice.entity.Supplier;
import com.kajanan.inventorysupplierservice.entity.Warehouse;

public class GenericMapper {

  public static Distributor distributorDtoToEntity (DistributorDto distributorDto) {
    return Distributor.builder()
      .name(distributorDto.getName())
      .distributorId(distributorDto.getDistributorId() !=null ? distributorDto.getDistributorId() : null )
      .location(distributorDto.getLocation())
      .phoneNo(distributorDto.getPhoneNo())
      .build();
  }

  public static Supplier supplierDtoToEntity (SupplierDto supplierDto) {
    return Supplier.builder()
      .name(supplierDto.getName())
      .supplierId(supplierDto.getSupplierId() !=null ? supplierDto.getSupplierId() : null )
      .location(supplierDto.getLocation())
      .phoneNo(supplierDto.getPhoneNo())
      .build();
  }

  public static Warehouse warehouseDtoToEntity (WarehouseDto warehouseDto) {
    return Warehouse.builder()
      .name(warehouseDto.getName())
      .warehouseId(warehouseDto.getWarehouseId() !=null ? warehouseDto.getWarehouseId() : null )
      .description(warehouseDto.getDescription())
      .build();
  }
}
