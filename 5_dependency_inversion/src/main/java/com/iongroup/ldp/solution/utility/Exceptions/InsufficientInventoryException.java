package com.iongroup.ldp.solution.utility.Exceptions;

public class InsufficientInventoryException extends Exception {
  public InsufficientInventoryException(String message, Exception innerException) {
    super(message, innerException);
  }
}
