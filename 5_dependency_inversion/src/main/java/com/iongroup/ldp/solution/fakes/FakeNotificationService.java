package com.iongroup.ldp.solution.fakes;

import com.iongroup.ldp.solution.interfaces.INotification;
import com.iongroup.ldp.solution.model.Cart;

public class FakeNotificationService implements INotification {
  public boolean wasCalled = false;

  @Override
  public void notifyCustomer(Cart cart) {
    wasCalled = true;
  }
}
