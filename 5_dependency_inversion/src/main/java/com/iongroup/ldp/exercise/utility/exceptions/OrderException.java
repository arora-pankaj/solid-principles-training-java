package com.iongroup.ldp.exercise.utility.exceptions;

import com.iongroup.ldp.exercise.utility.Logger;

public class OrderException extends Exception {
  public OrderException(String message, Exception innerException) {
    super(message, innerException);
    Logger.error(message, innerException);
  }
}
