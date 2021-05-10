package com.kajanan.inventoryauthservice.service;

import java.util.List;
import java.util.Map;

import com.kajanan.inventoryauthservice.dto.ForgotPasswordRequest;
import com.kajanan.inventoryauthservice.dto.LoginRequest;
import com.kajanan.inventoryauthservice.dto.LoginResponse;
import com.kajanan.inventoryauthservice.dto.RegisterRequest;
import com.kajanan.inventoryauthservice.dto.UpdateRequest;
import com.kajanan.inventoryauthservice.dto.UserDetailsDto;

public interface AuthService {
  LoginResponse login(LoginRequest loginRequest);

  UserDetailsDto register(RegisterRequest registerRequest);

  Map<String, String> updateUser(UpdateRequest updateRequest);

  List<UserDetailsDto> fetchAllUsers();

  UserDetailsDto fetchUserById(Long id);

  boolean checkIfUsernameExists(String username);

  Map<String, String> fetchSecurityQuestionForUser(String username);

  Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest);
}
