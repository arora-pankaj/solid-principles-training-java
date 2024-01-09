package com.iongroup.ldp.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToyStoryTest {
  BuzzLightyear buzz = new BuzzLightyear();
  SheriffWoody woody = new SheriffWoody();
  SlinkyDog slinky = new SlinkyDog();

  @Test
  public void buildBuzz() {
    buzz.setPrice(250);
    buzz.setColor("white");
    buzz.speak();
    buzz.fly();
    buzz.move();
    assertEquals(buzz.toString(), "The white Buzz Lightyear toys's price is 250$");
  }

  @Test
  public void buildWoody() {
    woody.setPrice(235);
    woody.setColor("brown");
    woody.speak();
    woody.move();
    assertEquals(woody.toString(), "The brown Sheriff Woody toys's price is 235$");
  }

  @Test
  public void buildSlinky() {
    slinky.setPrice(175);
    slinky.setColor("yellow");
    slinky.move();
    assertEquals(slinky.toString(), "The yellow Slinky Dog toys's price is 175$");
  }

  @Test
  public void isSubstitutableForSheriffWoody() {
    Toy woody = new SheriffWoody();
    woody.setPrice(217);
    woody.setColor("red");
    assertEquals(woody.toString(), "The red Sheriff Woody toys's price is 217$");
  }
}
