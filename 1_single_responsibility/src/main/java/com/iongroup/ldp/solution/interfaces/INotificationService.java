package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.Cart;

public interface INotificationService {
  public void notifyCustomerOrderCreated(Cart cart);
}
