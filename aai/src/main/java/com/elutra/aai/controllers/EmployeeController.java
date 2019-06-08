package com.elutra.aai.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elutra.aai.aaiexceptions.AAIBussinessException;
import com.elutra.aai.model.Employee;
import com.elutra.aai.service.EmployeeService;
import com.elutra.aai.utility.UserQuery;

@Controller
@RequestMapping(value={"/aai/employee"})
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@ResponseBody
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			return new ResponseEntity(new AAIBussinessException("Employee with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employeeQuery", method = RequestMethod.GET)
	public ModelAndView showEmployeeQuery() {
		ModelAndView modelAndView = new ModelAndView("employeeQueryPage");
		List<String> employeeFieldList = new ArrayList<String>();
		employeeFieldList.add("ID");
		employeeFieldList.add("PersonnelNumber");
		employeeFieldList.add("FirstName");
		employeeFieldList.add("LastName");
		employeeFieldList.add("DOB");
		employeeFieldList.add("EMAIL");
		employeeFieldList.add("Gender");
		modelAndView.addObject("employeeFieldList", employeeFieldList);
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		
		employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@ResponseBody
	@RequestMapping(value = "/getEmployeesByUserQuery", method = RequestMethod.POST)
	public ResponseEntity<?> getEmployeesByUserQuery(@RequestBody List<UserQuery> userQueryList) {
		
		List<Employee> employees = employeeService.getEmployeesByUserQuery(userQueryList);
		if(employees==null || employees.isEmpty()){
			return new ResponseEntity(new AAIBussinessException("No employee found for given query."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}

