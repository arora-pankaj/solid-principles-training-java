package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.interfaces.ReservationService;
import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.OrderItem;
import com.iongroup.ldp.solution.services.InventorySystem;
import com.iongroup.ldp.solution.utility.Exceptions.InsufficientInventoryException;

public class ReservationServiceImpl implements ReservationService {
  @Override
  public void reserveInventory(Cart cart) throws Exception {
    for (OrderItem item : cart.getItems()) {
      try {
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.reserve(item.getSku(), item.getQuantity());
      } catch (InsufficientInventoryException ex) {
        throw new InsufficientInventoryException(
            "Insufficient inventory for item " + item.getSku(), ex);
      } catch (Exception ex) {
        throw new com.iongroup.ldp.solution.utility.Exceptions.OrderException(
            "Problem reserving inventory", ex);
      }
    }
  }
}
