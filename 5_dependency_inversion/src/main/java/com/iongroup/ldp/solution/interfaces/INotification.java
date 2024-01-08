package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.Cart;

public interface INotification {
  void notifyCustomer(Cart cart) throws Exception;
}
