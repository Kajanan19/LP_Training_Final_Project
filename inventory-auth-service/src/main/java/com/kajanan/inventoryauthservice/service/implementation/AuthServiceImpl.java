package com.kajanan.inventoryauthservice.service.implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kajanan.inventoryauthservice.dto.ForgotPasswordRequest;
import com.kajanan.inventoryauthservice.dto.LoginRequest;
import com.kajanan.inventoryauthservice.dto.LoginResponse;
import com.kajanan.inventoryauthservice.dto.RegisterRequest;
import com.kajanan.inventoryauthservice.dto.UpdateRequest;
import com.kajanan.inventoryauthservice.dto.UserDetailsDto;
import com.kajanan.inventoryauthservice.entity.User;
import com.kajanan.inventoryauthservice.entity.UserDetails;
import com.kajanan.inventoryauthservice.exception.InvalidCredentialException;
import com.kajanan.inventoryauthservice.exception.UserNotFoundException;
import com.kajanan.inventoryauthservice.helper.UserDetailsMapper;
import com.kajanan.inventoryauthservice.repository.AddressRepository;
import com.kajanan.inventoryauthservice.repository.UserDetailsRepository;
import com.kajanan.inventoryauthservice.repository.UserRepository;
import com.kajanan.inventoryauthservice.security.JwtProvider;
import com.kajanan.inventoryauthservice.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

  private final UserDetailsRepository userDetailsRepository;
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtProvider jwtProvider;

  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    User user = findUserByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
    return LoginResponse.builder()
      .userId(user.getUserId())
      .username(user.getUsername())
      .role(user.getRole())
      .token(jwtProvider.generateTokenWithUsername(user.getUsername()))
      .build();
  }

  @Override
  public UserDetailsDto register(RegisterRequest registerRequest) {
    checkIfUsernameExists(registerRequest.getUsername());
    registerRequest.setPassword(encodePassword(registerRequest.getPassword()));
    registerRequest.setAddress(addressRepository.save(registerRequest.getAddress()));
    UserDetails userDetails = userDetailsRepository.save(UserDetailsMapper.registerToUserDetails(registerRequest));
    return UserDetailsMapper.userDetailsToDto(userDetails);
  }

  @Override
  public Map<String, String> updateUser(UpdateRequest updateRequest) {
    UserDetails details = userDetailsRepository.findById(updateRequest.getUserId()).orElseThrow(() -> new UserNotFoundException());
    updateRequest.getAddress().setAddressId(details.getAddress().getAddressId());
    addressRepository.save(updateRequest.getAddress());
    userDetailsRepository.save(UserDetailsMapper.updateRequestToUserDetails(updateRequest));
    return Collections.singletonMap("userId", updateRequest.getUserId().toString());
  }

  @Override
  @Transactional(readOnly = true)
  public List<UserDetailsDto> fetchAllUsers() {
    return userDetailsRepository
      .findAll()
      .stream()
      .map(UserDetailsMapper::userDetailsToDto)
      .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetailsDto fetchUserById(Long id) {
    return UserDetailsMapper.userDetailsToDto(
      userDetailsRepository
        .findById(id)
        .orElseThrow(() -> new InvalidCredentialException("userId", "ID " + id + " doesn't exist"))
    );
  }

  @Transactional(readOnly = true)
  public User findUserByCredentials(String username, String password) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"));
    if (!passwordEncoder.matches(password, user.getPassword())) throw new InvalidCredentialException("password", "Invalid Password");
    return user;
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkIfUsernameExists(String username) {
    if (!userRepository.existsByUsername(username)) return false;
    else throw new InvalidCredentialException("username", "Username already exists");
  }

  @Override
  @Transactional(readOnly = true)
  public Map<String, String> fetchSecurityQuestionForUser(String username) {
    HashMap<String, String> responseMap = new HashMap<>();
    responseMap.put("username", username);
    responseMap.put("securityQuestion", userDetailsRepository.findByUserUsername(username)
      .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"))
      .getSecurityQuestion());
    return responseMap;
  }

  @Override
  public Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest) {
    UserDetails userDetails = userDetailsRepository
      .findByUserUsername(forgotPasswordRequest.getUsername())
      .orElseThrow(() -> new InvalidCredentialException("username", "User " + forgotPasswordRequest.getUsername() + " doesn't exist"));
    if(!userDetails.getSecurityAnswer().toLowerCase().equals(forgotPasswordRequest.getSecurityAnswer().toLowerCase()))
      throw new InvalidCredentialException("securityAnswer", "Invalid Answer");
    User user = userDetails.getUser();
    user.setPassword(encodePassword(forgotPasswordRequest.getNewPassword()));
    userRepository.save(user);
    return Collections.singletonMap("userId", userDetails.getUserDetailsId().toString());
  }

  private String encodePassword(String password) {
    return passwordEncoder.encode(password);
  }

}
