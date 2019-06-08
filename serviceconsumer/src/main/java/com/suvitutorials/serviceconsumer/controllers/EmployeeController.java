package com.suvitutorials.serviceconsumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.suvitutorials.serviceconsumer.models.Employee;

@RestController
@RequestMapping(value={"/suvitutorial"})
public class EmployeeController {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	@RequestMapping(value={"/getemployeebyid/{id}"}, method=RequestMethod.GET)
public Employee getEmployeeById(@PathVariable("id") Integer id){
		System.out.println("ID is "+id);
		ServiceInstance serviceInstance=loadBalancer.choose("EMPLOYEE-SERVICE");

		System.out.println("URI of micoservice instance---"+serviceInstance.getUri());
		String baseUrl = serviceInstance.getUri().toString();
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(baseUrl);
		
		ResponseEntity<Employee> employee = restTemplate.getForEntity(baseUrl+"/employee/"+id, Employee.class);
		return employee.getBody();
}
}
