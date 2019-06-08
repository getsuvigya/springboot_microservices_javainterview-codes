package design_patterns.decoratordesignpattern;

public class CarDecorator implements Car{
	
	protected Car car;
	
	public CarDecorator(Car c) {
		// TODO Auto-generated constructor stub
		this.car = c;
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		car.assemble();
	}
	

}
