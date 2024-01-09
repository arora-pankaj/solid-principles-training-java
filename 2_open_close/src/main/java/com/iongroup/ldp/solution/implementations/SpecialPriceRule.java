package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.PriceRule;

public class SpecialPriceRule implements PriceRule {
  @Override
  public boolean isMatch(OrderItem orderItem) {
    return orderItem.getSku().startsWith("SPECIAL");
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    float total = orderItem.getQuantity() * .4f;
    int setsOfThree = orderItem.getQuantity() / 3;
    total -= setsOfThree * .2f;
    return total;
  }
}
