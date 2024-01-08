package com.iongroup.ldp.violation.services;

import com.iongroup.ldp.violation.utility.exceptions.InsufficientInventoryException;

public class InventorySystem {
  public void reserve(String sku, int quantity) throws InsufficientInventoryException {
    throw new InsufficientInventoryException();
  }
}
