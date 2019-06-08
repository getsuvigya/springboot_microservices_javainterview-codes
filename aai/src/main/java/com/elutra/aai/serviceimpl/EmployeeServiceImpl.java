package com.elutra.aai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elutra.aai.dao.EmployeeDAO;
import com.elutra.aai.model.Employee;
import com.elutra.aai.service.EmployeeService;
import com.elutra.aai.utility.UserQuery;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;

	public Integer createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
		
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
		
	}

	public List<Employee> getEmployeesByUserQuery(List<UserQuery> userQueryList) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeesByUserQuery(userQueryList);
	}

}
