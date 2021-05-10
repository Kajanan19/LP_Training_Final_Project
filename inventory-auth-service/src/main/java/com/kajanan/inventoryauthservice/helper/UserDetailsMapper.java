package com.kajanan.inventoryauthservice.helper;

import com.kajanan.inventoryauthservice.dto.RegisterRequest;
import com.kajanan.inventoryauthservice.dto.UpdateRequest;
import com.kajanan.inventoryauthservice.dto.UserDetailsDto;
import com.kajanan.inventoryauthservice.entity.User;
import com.kajanan.inventoryauthservice.entity.UserDetails;
import com.kajanan.inventoryauthservice.enums.Gender;

public class UserDetailsMapper {

  public static UserDetails registerToUserDetails(RegisterRequest registerRequest) {
    User user = User.builder()
      .username(registerRequest.getUsername())
      .password(registerRequest.getPassword())
      .role("User")
      .build();
    return UserDetails.builder()
      .user(user)
      .address(registerRequest.getAddress())
      .firstName(registerRequest.getFirstName())
      .lastName(registerRequest.getLastName())
      .securityQuestion("Default Question")
      .securityAnswer("answer")
      .designation(registerRequest.getDesignation())
      .gender(Gender.valueOf(registerRequest.getGender()))
      .dob(registerRequest.getDob())
      .emailId(registerRequest.getEmailId())
      .phoneNo(registerRequest.getPhoneNo())
      .build();
  }

  public static UserDetailsDto userDetailsToDto(UserDetails userDetails){
    return UserDetailsDto.builder()
      .userId(userDetails.getUserDetailsId())
      .username(userDetails.getUser().getUsername())
      .role(userDetails.getUser().getRole())
      .phoneNo(userDetails.getPhoneNo())
      .gender(userDetails.getGender().toString())
      .designation(userDetails.getDesignation())
      .dob(userDetails.getDob())
      .emailId(userDetails.getEmailId())
      .address(userDetails.getAddress())
      .firstName(userDetails.getFirstName())
      .lastName(userDetails.getLastName())
      .build();
  }

  public static UserDetails updateRequestToUserDetails(UpdateRequest updateRequest) {
    return UserDetails.builder()
      .firstName(updateRequest.getFirstName())
      .lastName(updateRequest.getLastName())
      .address(updateRequest.getAddress())
      .userDetailsId(updateRequest.getUserId())
      .phoneNo(updateRequest.getPhoneNo())
      .gender(Gender.valueOf(updateRequest.getGender()))
      .designation(updateRequest.getDesignation())
      .dob(updateRequest.getDob())
      .emailId(updateRequest.getEmailId())
      .securityQuestion(updateRequest.getSecurityQuestion())
      .securityAnswer(updateRequest.getSecurityAnswer())
      .build();
  }

}
