package com.kajanan.inventoryrawmaterialorderservice.dto;

import java.time.LocalDate;

import com.kajanan.inventoryrawmaterialorderservice.entity.Warehouse;
import com.kajanan.inventoryrawmaterialorderservice.enums.MeasurementUnit;
import com.kajanan.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.kajanan.inventoryrawmaterialorderservice.enums.QualityCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialOrderResponse {

  private Long rawMaterialOrderId;
  private Double pricePerUnit;
  private Double quantity;
  private QualityCheck qualityCheck;
  private OrderStatus orderStatus;
  private LocalDate deliveryDate;
  private LocalDate expiryDate;
  private LocalDate orderedOn;
  private String supplierName;
  private Long supplierId;
  private String materialName;
  private String description;
  private MeasurementUnit measurementUnit;
  private Warehouse warehouse;

}
