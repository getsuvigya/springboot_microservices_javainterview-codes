package design_patterns.abstractfactorydesignpattern;

public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		Shape shape=null;
		if(shapeType.equals("circle")){
			shape = new Square();
		}
		if(shapeType.equals("square")){
			shape = new Square();
		}
		return shape;
	}

	@Override
	public Color getColor(String colorType) {
		// TODO Auto-generated method stub
		return null;
	}

}
