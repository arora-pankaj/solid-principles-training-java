package com.iongroup.ldp.solution.utility.Exceptions;

public class OrderException extends Exception {
  public OrderException(String message, Exception innerException) {
    super(message, innerException);
  }
}
