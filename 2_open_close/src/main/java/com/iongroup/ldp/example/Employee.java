package com.iongroup.ldp.example;

public class Employee {

  private final int salary;
  private final int bonus;
  private final EmployeeType employeeType;

  Employee(int salary, int bonus, EmployeeType employeeType) {
    this.salary = salary;
    this.bonus = bonus;
    this.employeeType = employeeType;
  }

  public int payAmount() {
    return employeeType.calculateSalary(salary, bonus);
  }
}
