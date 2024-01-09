package com.iongroup.ldp.example;

import java.time.MonthDay;
import java.util.List;

public interface EmployeeRepository {
  List<Employee> findEmployeesBornOn(MonthDay monthDay);
}
