package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.IPriceRule;
import com.iongroup.ldp.solution.interfaces.IPricingCalculator;
import java.util.ArrayList;
import java.util.List;

public class PricingCalculator implements IPricingCalculator {
  private final List<IPriceRule> pricingRules;

  public PricingCalculator() {
    this.pricingRules = new ArrayList<>();
    pricingRules.add(new EachPriceRule());
    pricingRules.add(new PerGramPriceRule());
    pricingRules.add(new SpecialPriceRule());
    pricingRules.add(new SpecialPrice4BuyGetOneFree());
  }

  @Override
  public float CalculatePrice(OrderItem orderItem) {
    float total =
        pricingRules.stream()
            .filter(rule -> rule.isMatch(orderItem))
            .findFirst()
            .get()
            .calculatePrice(orderItem);
    return total;
  }
}
