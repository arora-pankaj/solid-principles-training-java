package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.IPriceRule;

public class EachPriceRule implements IPriceRule {
  @Override
  public boolean isMatch(OrderItem orderItem) {
    return orderItem.getSku().startsWith("EACH");
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    return orderItem.getQuantity() * 2;
  }
}
