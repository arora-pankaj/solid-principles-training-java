package com.iongroup.ldp.example;

public enum EmployeeType {
  MANAGER((salary, bonus) -> salary + bonus),
  ENGINEER((salary, bonus) -> salary);

  private final SalaryCalculator salaryCalculator;

  EmployeeType(SalaryCalculator salaryCalculator) {
    this.salaryCalculator = salaryCalculator;
  }

  public int calculateSalary(int salary, int bonus) {
    return salaryCalculator.calculateSalary(salary, bonus);
  }

  public interface SalaryCalculator {
    int calculateSalary(int salary, int bonus);
  }
}
