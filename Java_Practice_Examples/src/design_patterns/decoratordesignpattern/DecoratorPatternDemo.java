package design_patterns.decoratordesignpattern;

public class DecoratorPatternDemo {
public static void main(String[] args) {
	/*Car sportsCar = new SportsCar(new BasicCar());
	sportsCar.assemble();
	*/
	Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
	System.out.println("Creating luxury sports car");
	luxurySportsCar.assemble();
}
}
