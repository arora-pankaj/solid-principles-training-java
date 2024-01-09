package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.PriceRule;

public class PerGramPriceRule implements PriceRule {
  @Override
  public boolean isMatch(OrderItem orderItem) {
    return orderItem.getSku().startsWith("WEIGHT");
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    return (float) (orderItem.getQuantity() * 6) / 1000;
  }
}
