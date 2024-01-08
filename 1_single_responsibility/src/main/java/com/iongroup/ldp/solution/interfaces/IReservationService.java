package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.OrderItem;

public interface IReservationService {
  public void reserveInventory(Iterable<OrderItem> items) throws Exception;
}
