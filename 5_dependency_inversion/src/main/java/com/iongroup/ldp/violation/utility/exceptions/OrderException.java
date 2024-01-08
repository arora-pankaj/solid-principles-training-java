package com.iongroup.ldp.violation.utility.exceptions;

import com.iongroup.ldp.violation.utility.Logger;

public class OrderException extends Exception {
  public OrderException(String message, Exception innerException) {
    super(message, innerException);
    Logger.error(message, innerException);
  }
}
