package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.interfaces.ReservationService;
import com.iongroup.ldp.solution.model.OrderItem;
import com.iongroup.ldp.solution.services.InventorySystem;
import com.iongroup.ldp.solution.utility.Exceptions.InsufficientInventoryException;
import com.iongroup.ldp.solution.utility.Exceptions.OrderException;

public class ReservationServiceImpl implements ReservationService {

  @Override
  public void reserveInventory(Iterable<OrderItem> items) throws Exception {
    for (OrderItem item : items) {
      try {
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.reserve(item.getSku(), item.getQuantity());
      } catch (InsufficientInventoryException ex) {
        throw new OrderException("Insufficient inventory for item " + item.getSku(), ex);
      } catch (Exception ex) {
        throw new OrderException("Problem reserving inventory", ex);
      }
    }
  }
}
