package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.IPriceRule;

public class PerGramPriceRule implements IPriceRule {
  @Override
  public boolean isMatch(OrderItem orderItem) {
    return orderItem.getSku().startsWith("WEIGHT");
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    return orderItem.getQuantity() * 6 / 1000;
  }
}
