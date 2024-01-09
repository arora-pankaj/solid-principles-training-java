package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.OrderItem;

public interface ReservationService {

  void reserveInventory(Iterable<OrderItem> items) throws Exception;
}
