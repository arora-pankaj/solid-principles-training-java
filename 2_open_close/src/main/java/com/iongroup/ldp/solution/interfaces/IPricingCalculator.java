package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.OrderItem;

public interface IPricingCalculator {
  float CalculatePrice(OrderItem orderItem);
}
