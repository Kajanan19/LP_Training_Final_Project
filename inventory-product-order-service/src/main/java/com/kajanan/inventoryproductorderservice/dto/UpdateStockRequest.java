package com.kajanan.inventoryproductorderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStockRequest {
  private Long productId;
  private Double quantity;
}
