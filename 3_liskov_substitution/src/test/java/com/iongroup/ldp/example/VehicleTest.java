package com.iongroup.ldp.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VehicleTest {
  @Test
  public void start_engine() {
    Vehicle vehicle = new TestableVehicle();

    vehicle.startEngine();

    assertTrue(vehicle.engineIsStarted());
  }

  @Test
  public void stop_engine() {
    Vehicle vehicle = new TestableVehicle();

    vehicle.startEngine();
    vehicle.stopEngine();

    assertFalse(vehicle.engineIsStarted());
  }

  public static class TestableVehicle extends Vehicle {

    @Override
    public void fillUpWithFuel() {}

    @Override
    public void chargeBattery() {}
  }
}
