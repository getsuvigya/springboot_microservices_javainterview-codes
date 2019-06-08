package com.suvitutorials.restapptutorial.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Employee implements Serializable
{
	@NotNull
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
