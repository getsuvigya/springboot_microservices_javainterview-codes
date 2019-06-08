package java8tutorials.practicalexample.java8collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8CollectionDemo {
public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Suvi");
		e.setAge(30);
		e.setEmpId(123);
		Employee e1 = new Employee();
		e1.setName("Nandini");
		e1.setAge(24);
		e1.setEmpId(234);
		Employee e2 = new Employee();
		e2.setName("Ankit");
		e2.setAge(28);
		e2.setEmpId(345);
		Employee e3 = new Employee();
		e3.setName("Ankit");
		e3.setAge(38);
		e3.setEmpId(445);
		List<Employee> list = new ArrayList<>();
		list.add(e3);
		list.add(e2);
		list.add(e1);
		list.add(e);
		Comparator<Employee> comp = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
		Collections.sort(list,comp);
		for (Employee employee : list) {
			System.out.println(employee);
		}
}


}
