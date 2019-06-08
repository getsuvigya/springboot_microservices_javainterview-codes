package design_patterns.factoryDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class FetchEmployeeRoleFactory {
	public static Map<String, EmployeeTypeEnum> map = new HashMap<>();
	static{
		map.put("cto", EmployeeTypeEnum.CTO);
		map.put("ceo", EmployeeTypeEnum.CEO);
		map.put("developer", EmployeeTypeEnum.DEVELOPER);
	}
public static void main(String[] args) {
	String employeeType = "cto";
	System.out.println(map.get(employeeType).getRoles().getRole());
}
}
