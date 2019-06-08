package com.elutra.aai.dao;

import java.util.List;

import com.elutra.aai.model.Employee;
import com.elutra.aai.utility.UserQuery;

public interface EmployeeDAO {
 public Integer createEmployee(Employee employee);
 public List<Employee> getEmployees();
 public Employee findById(long id);
 List<Employee> getEmployeesByUserQuery(List<UserQuery> userQueryList);
}
