package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.OrderItem;

public interface IPriceRule {
  boolean isMatch(OrderItem orderItem);

  float calculatePrice(OrderItem orderItem);
}
