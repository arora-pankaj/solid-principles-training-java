package com.iongroup.ldp.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {

  private static final int BONUS = 100;
  private static final int SALARY = 1000;

  @Test
  public void not_add_bonus_to_the_engineer_pay_amount() {
    Employee employee = new Employee(SALARY, BONUS, EmployeeType.ENGINEER);
    assertEquals(SALARY, employee.payAmount());
  }

  @Test
  public void add_bonus_to_the_manager_pay_amount() {
    Employee employee = new Employee(SALARY, BONUS, EmployeeType.MANAGER);
    assertEquals(SALARY + BONUS, employee.payAmount());
  }
}
