package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.PriceRule;

public class SpecialPrice4BuyGetOneFree implements PriceRule {
  @Override
  public boolean isMatch(OrderItem orderItem) {
    return orderItem.getSku().startsWith("B4GOF");
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    float total = orderItem.getQuantity();
    int setsOfFive = orderItem.getQuantity() / 5;
    total -= setsOfFive;
    return total;
  }
}
