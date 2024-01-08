package com.iongroup.ldp.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTest {
  private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
  private final Dog dog = new Dog();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(consoleContent));
  }

  @Test
  void run() {
    dog.run();
    assertEquals("Dog is running", consoleContent.toString());
  }

  @Test
  void bark() {
    dog.bark();
    assertEquals("Dog is barking", consoleContent.toString());
  }
}
