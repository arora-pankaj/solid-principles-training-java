package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.implementations.ReservationServiceImpl;
import com.iongroup.ldp.solution.interfaces.ReservationService;

public class PosCashOrder extends Order {

  private final ReservationService reservationService;

  public PosCashOrder(Cart cart) {
    super(cart);
    this.reservationService = new ReservationServiceImpl();
  }

  @Override
  public void checkout() throws Exception {
    reservationService.reserveInventory(cart.getItems());
  }
}
