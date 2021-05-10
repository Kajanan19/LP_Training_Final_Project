package com.kajanan.inventoryrawmaterialorderservice.helper;

import java.time.LocalDate;

import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.kajanan.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.kajanan.inventoryrawmaterialorderservice.entity.RawMaterial;
import com.kajanan.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.kajanan.inventoryrawmaterialorderservice.entity.Supplier;
import com.kajanan.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.kajanan.inventoryrawmaterialorderservice.enums.QualityCheck;

public class RawMaterialMapper {

  public static RawMaterialOrderResponse entityToDto (RawMaterialOrder rawMaterialOrder) {
    return RawMaterialOrderResponse.builder()
      .materialName(rawMaterialOrder.getRawMaterial().getMaterialName())
      .rawMaterialOrderId(rawMaterialOrder.getRawMaterialOrderId())
      .quantity(rawMaterialOrder.getQuantity())
      .pricePerUnit(rawMaterialOrder.getPricePerUnit())
      .qualityCheck(rawMaterialOrder.getQualityCheck())
      .orderStatus(rawMaterialOrder.getOrderStatus())
      .deliveryDate(rawMaterialOrder.getDeliveryDate())
      .expiryDate(rawMaterialOrder.getExpiryDate())
      .orderedOn(rawMaterialOrder.getOrderedOn())
      .supplierName(rawMaterialOrder.getSupplier().getName())
      .supplierId(rawMaterialOrder.getSupplier().getSupplierId())
      .warehouse(rawMaterialOrder.getRawMaterial().getWarehouse())
      .measurementUnit(rawMaterialOrder.getRawMaterial().getQuantityUnit())
      .description(rawMaterialOrder.getRawMaterial().getDescription())
      .build();
  }

  
  public static RawMaterialOrder DtoToEntity(RawMaterialOrderRequest request) {
    RawMaterialOrder order = new RawMaterialOrder();
    Supplier supplier = new Supplier();
    supplier.setSupplierId(request.getSupplierId());
    RawMaterial rawMaterial = new RawMaterial();
    rawMaterial.setRawMaterialId(request.getRawMaterialId());
    order.setDeliveryDate(request.getDeliveryDate());
    order.setExpiryDate(request.getExpiryDate());
    order.setOrderStatus(OrderStatus.Processing);
    order.setSupplier(supplier);
    order.setPricePerUnit(request.getPricePerUnit());
    order.setQuantity(request.getQuantity());
    order.setOrderedOn(LocalDate.now());
    order.setQualityCheck(QualityCheck.valueOf(request.getQualityCheck()));
    order.setRawMaterial(rawMaterial);
    return order;
  }
}
