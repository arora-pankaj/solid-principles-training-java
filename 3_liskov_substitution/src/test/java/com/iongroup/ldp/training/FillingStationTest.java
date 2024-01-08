package com.iongroup.ldp.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class FillingStationTest {

  private static final int FULL = 100;
  private final FillingStation fillingStation = new FillingStation();

  @Test
  public void refuel_a_petrol_car() {
    PetrolCar car = new PetrolCar();

    fillingStation.refuel(car);

    assertEquals(FULL, car.fuelTankLevel());
  }

  @Test
  public void not_fail_refueling_an_electric_car() {
    ElectricCar car = new ElectricCar();

    try {
      fillingStation.refuel(car);
    } catch (Throwable throwable) {
      fail(throwable);
    }
  }

  @Test
  public void recharge_an_electric_car() {
    ElectricCar car = new ElectricCar();

    fillingStation.charge(car);

    assertEquals(FULL, car.batteryLevel());
  }

  @Test
  public void not_fail_recharging_a_petrol_car() {
    PetrolCar car = new PetrolCar();

    try {
      fillingStation.charge(car);
    } catch (Throwable throwable) {
      fail(throwable);
    }
  }
}
