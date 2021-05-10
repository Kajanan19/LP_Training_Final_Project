package com.kajanan.inventoryauthservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class LoginResponse {

  private Long userId;
  private String token;
  private String role;
  private String username;

}
