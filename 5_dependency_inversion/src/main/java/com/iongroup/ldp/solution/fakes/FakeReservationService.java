package com.iongroup.ldp.solution.fakes;

import com.iongroup.ldp.solution.interfaces.IReservation;
import com.iongroup.ldp.solution.model.Cart;

public class FakeReservationService implements IReservation {
  public boolean wasCalled = false;

  @Override
  public void reserveInventory(Cart cart) {
    wasCalled = true;
  }
}
