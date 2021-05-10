package com.kajanan.inventorygatewayserver.exception;

public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 5512565657286379434L;

  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(String message) {
    super(message);
  }

}