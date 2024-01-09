package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.OrderItem;

public interface PricingCalculator {
  float calculatePrice(OrderItem orderItem);
}
