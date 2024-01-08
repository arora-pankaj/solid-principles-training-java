package com.iongroup.ldp.solution.services;

import com.iongroup.ldp.solution.utility.Exceptions.InsufficientInventoryException;

public class InventorySystem {
  public void reserve(String sku, int quantity) throws InsufficientInventoryException {
    throw new InsufficientInventoryException("InventorySystem Not Implemented", null);
  }
}
