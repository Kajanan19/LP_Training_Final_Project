package com.kajanan.inventoryproductorderservice.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kajanan.inventoryproductorderservice.dto.UpdateStockRequest;
import com.kajanan.inventoryproductorderservice.entity.Product;
import com.kajanan.inventoryproductorderservice.service.UpdateStockService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStockServiceImpl implements UpdateStockService {

  private final RestTemplate restTemplate;

  @Override
  public boolean updateProductStock(Long productId, Double quantity) {

    // Prepare header
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
    ObjectMapper mapper = new ObjectMapper();
    String requestBody;
    try {
      requestBody = mapper.writeValueAsString(new UpdateStockRequest(productId, quantity));
      HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers);
      return restTemplate
          .exchange("http://inventory-stock-management-service/productStock", HttpMethod.PUT, entity, Product.class)
          .getStatusCode().is2xxSuccessful();
    } catch (JsonProcessingException e) {
      log.info(e.getMessage());
    }

    return false;
  }

}
