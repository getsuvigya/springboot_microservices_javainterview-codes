package design_patterns.decoratordesignpattern;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public void assemble(){
		super.assemble();
		System.out.println("Adding features of luxury car");
	}
}
