package com.iongroup.ldp.violation.regular;

public class AreaCalculator {
  public static int CalculateArea(Square square) {
    return square.getHeight() * square.getHeight();
  }

  public static int CalculateArea(Rectangle rectangle) {
    return rectangle.getHeight() * rectangle.getWidth();
  }
}
