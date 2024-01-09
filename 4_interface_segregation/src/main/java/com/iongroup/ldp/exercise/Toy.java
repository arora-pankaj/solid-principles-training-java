package com.iongroup.ldp.exercise;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public interface Toy {
  void setPrice(int price);

  void setColor(String color);

  void move() throws NotImplementedException;

  void fly() throws NotImplementedException;

  void speak() throws NotImplementedException;
}
