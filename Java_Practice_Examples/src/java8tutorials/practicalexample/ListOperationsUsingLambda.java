package java8tutorials.practicalexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOperationsUsingLambda {
public static void main(String[] args) {
	List<Product> list = new ArrayList<Product>();
	Product p1 = new Product();
	p1.id=1;p1.name="Apple";
	Product p2 = new Product();
	p2.id=2;p2.name="Mango";
	Product p3 = new Product();
	p3.id=3; p3.name="Grapes";
	list.add(p1);
	list.add(p2);
	list.add(p3);
	Comparator<Product> comparator = (Product o1, Product o2)->{
		return (o1.name).compareTo(o2.name);
	};
	Collections.sort(list, comparator);
	for(Product p: list){
		System.out.println(p.name);
	}
}
}
