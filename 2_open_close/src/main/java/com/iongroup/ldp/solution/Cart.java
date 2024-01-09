package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.implementations.PricingCalculatorImpl;
import com.iongroup.ldp.solution.interfaces.PricingCalculator;
import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<OrderItem> items;
  private final PricingCalculator pricingCalculator;

  public Cart() {
    this.pricingCalculator = new PricingCalculatorImpl();
    this.items = new ArrayList<>();
  }

  public void add(OrderItem orderItem) {
    items.add(orderItem);
  }

  public float totalAmount() {
    float total = 0;

    for (OrderItem orderItem : items) {
      total += pricingCalculator.calculatePrice(orderItem);
    }

    return total;
  }
}
