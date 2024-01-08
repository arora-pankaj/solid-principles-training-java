package com.isapanah.srp.refactored.Implementations;

import com.isapanah.srp.refactored.Model.OrderItem;
import com.isapanah.srp.refactored.Services.InventorySystem;
import com.isapanah.srp.refactored.Utility.Exceptions.InsufficientInventoryException;
import com.isapanah.srp.refactored.Utility.Exceptions.OrderException;
import com.isapanah.srp.refactored.Interfaces.IReservationService;

public class ImplReservationService implements IReservationService {

    @Override
    public void reserveInventory(Iterable<OrderItem> items) throws Exception {
        for(OrderItem item : items)
        {
            try
            {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.getSku(), item.getQuantity());
            }
            catch (InsufficientInventoryException ex)
            {
                throw new OrderException("Insufficient inventory for item " + item.getSku(), ex);
            }
            catch (Exception ex)
            {
                throw new OrderException("Problem reserving inventory", ex);
            }
        }
    }

}
