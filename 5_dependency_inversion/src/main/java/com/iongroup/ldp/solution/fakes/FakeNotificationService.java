package com.iongroup.ldp.solution.fakes;

import com.iongroup.ldp.solution.interfaces.NotificationService;
import com.iongroup.ldp.solution.model.Cart;

public class FakeNotificationService implements NotificationService {
  public boolean wasCalled = false;

  @Override
  public void notifyCustomer(Cart cart) {
    wasCalled = true;
  }
}
