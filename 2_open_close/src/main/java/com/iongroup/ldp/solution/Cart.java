package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.implementations.PricingCalculator;
import com.iongroup.ldp.solution.interfaces.IPricingCalculator;
import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<OrderItem> items;
  private IPricingCalculator pricingCalculator;

  public Cart() {
    pricingCalculator = new PricingCalculator();
    this.items = new ArrayList<>();
  }

  public void Add(OrderItem orderItem) {
    items.add(orderItem);
  }

  public float totalAmount() {
    float total = 0;

    for (OrderItem orderItem : items) {
      total += pricingCalculator.CalculatePrice(orderItem);
    }

    return total;
  }
}
