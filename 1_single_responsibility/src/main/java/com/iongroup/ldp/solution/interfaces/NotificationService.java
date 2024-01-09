package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.Cart;

public interface NotificationService {
  void notifyCustomerOrderCreated(Cart cart);
}
