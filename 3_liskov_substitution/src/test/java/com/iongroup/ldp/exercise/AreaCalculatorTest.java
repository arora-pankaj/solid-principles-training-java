package com.iongroup.ldp.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {
  @Test
  public void CalculateSquareArea() {
    Square square = new Square();
    square.setWidth(2);
    Assertions.assertEquals(4, AreaCalculator.CalculateArea(square));
  }

  @Test
  public void CalculateRectangleArea() {
    Rectangle rectangle = new Rectangle();
    rectangle.setWidth(2);
    rectangle.setHeight(3);
    assertEquals(6, AreaCalculator.CalculateArea(rectangle));
  }

  @Test
  public void CalculateMixtureShapeArea() {
    Rectangle rectangle = new Square();
    rectangle.setWidth(4);
    rectangle.setHeight(5);
    assertEquals(20, AreaCalculator.CalculateArea(rectangle));
  }
}
