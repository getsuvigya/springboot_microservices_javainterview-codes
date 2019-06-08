package com.suvitutorials.serviceconsumer.models;

import java.io.Serializable;

public class Employee implements Serializable
{
/**
	 * 
	 */
	private static final long serialVersionUID = -7796153711642524361L;
private String name;
private Integer roll;
private String servicePort;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getRoll() {
	return roll;
}
public void setRoll(Integer roll) {
	this.roll = roll;
}
public String getServicePort() {
	return servicePort;
}
public void setServicePort(String servicePort) {
	this.servicePort = servicePort;
}


}
