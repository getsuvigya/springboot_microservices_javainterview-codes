package design_patterns.decoratordesignpattern;

public class SportsCar extends CarDecorator{

	public SportsCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public void assemble(){
		super.assemble();
		System.out.println("Adding features of sportscar");
	}
}
