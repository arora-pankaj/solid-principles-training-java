package com.iongroup.ldp.violation.utility.exceptions;

public class OrderException extends Exception {
  public OrderException(String message, Exception innerException) {
    super(message, innerException);
  }
}
