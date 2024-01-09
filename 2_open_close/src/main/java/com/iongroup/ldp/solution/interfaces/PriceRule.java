package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.OrderItem;

public interface PriceRule {
  boolean isMatch(OrderItem orderItem);

  float calculatePrice(OrderItem orderItem);
}
