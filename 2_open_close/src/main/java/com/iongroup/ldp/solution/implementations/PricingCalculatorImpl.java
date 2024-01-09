package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.OrderItem;
import com.iongroup.ldp.solution.interfaces.PriceRule;
import com.iongroup.ldp.solution.interfaces.PricingCalculator;
import java.util.ArrayList;
import java.util.List;

public class PricingCalculatorImpl implements PricingCalculator {
  private final List<PriceRule> pricingRules;

  public PricingCalculatorImpl() {
    this.pricingRules = new ArrayList<>();
    pricingRules.add(new EachPriceRule());
    pricingRules.add(new PerGramPriceRule());
    pricingRules.add(new SpecialPriceRule());
    pricingRules.add(new SpecialPrice4BuyGetOneFree());
  }

  @Override
  public float calculatePrice(OrderItem orderItem) {
    PriceRule matchingPriceRule =
        pricingRules.stream()
            .filter(rule -> rule.isMatch(orderItem))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Matching price rule not found."));
    return matchingPriceRule.calculatePrice(orderItem);
  }
}
