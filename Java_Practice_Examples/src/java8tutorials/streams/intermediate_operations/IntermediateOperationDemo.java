package java8tutorials.streams.intermediate_operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//In case of streams whenever you perform any intermediate operation or terminal operation, 
//the stream is either operated or closed so you can not use the same stream reference again which is refering to the input stream
//either create a new reference for the resultant stream from the operation or make the old reference point to the new stream returned by the operation
public class IntermediateOperationDemo {
public static void main(String[] args) {
	List<String> memberNames = new ArrayList<>();
	memberNames.add("Amitabh");
	memberNames.add("Shekhar");
	memberNames.add("Aman");
	memberNames.add("Rahul");
	memberNames.add("Shahrukh");
	memberNames.add("Salman");
	memberNames.add("Yana");
	memberNames.add("Lokesh");
	Stream<String> s = memberNames.stream();
	//example for filter method
	//filter accepts predicate as parameter and internally calls predicate.test(T t) for each element of stream
	/*Predicate<String> predicate = (String name)->name.startsWith("S");
	s = s.filter(predicate);*/
	s = s.filter(name -> name.startsWith("S"));
	//forEach accepts Consumer as parameter which is functional interface with abstract method accept(Object 0) and calls accept method internally.
	Consumer<String> consumer = (String s1)->System.out.println(s1);
	s.forEach(consumer);
	//example of map method
	//map accepts Function as a reference which is functional interface with abstract method R apply(T t) which 
	//converts the given object into another type of object. So, the apply method is called internally by map method
	Function<String, Employee> func = (String name)->{
		return new Employee(name);
	};
	Stream<String> membersStream = memberNames.stream();
	Stream<Employee> employees = membersStream.map(func);
	Consumer<Employee> employeeConsumer = (Employee emp)->System.out.println(emp);
	employees.forEach(employeeConsumer);
	//Example of sorted(comparator) method to sort list of employees by passing a comparator for wrapper and string classes use sorted().
	Comparator<Employee> comp = (e1, e2)->e1.getName().compareTo(e2.getName());
	Stream<String> membersStream2 = memberNames.stream();
	Stream<Employee> employees2 = membersStream2.map(func);
	Stream<Employee> sortedEmployees = employees2.sorted(comp);
	List<Employee> empList = sortedEmployees.collect(Collectors.toList());
	empList.forEach(employeeConsumer);
}
}

class Employee{
	String name;
	Integer id;
	static int i=0;
	Employee(){
	}
	Employee(String name){
		this.name = name;
		id=i++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString(){
		return this.name+" : "+this.id;
	}
}