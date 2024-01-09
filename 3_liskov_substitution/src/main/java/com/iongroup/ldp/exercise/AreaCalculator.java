package com.iongroup.ldp.exercise;

public class AreaCalculator {
  public static int CalculateArea(Square square) {
    return square.getHeight() * square.getHeight();
  }

  public static int CalculateArea(Rectangle rectangle) {
    return rectangle.getHeight() * rectangle.getWidth();
  }
}
