package com.elutra.aai.utility;

import java.util.List;

public class UserQuery {
private String column;
private String operator;
private List<String> values;
public String getColumn() {
	return column;
}
public void setColumn(String column) {
	this.column = column;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public List<String> getValues() {
	return values;
}
public void setValues(List<String> values) {
	this.values = values;
}

}
