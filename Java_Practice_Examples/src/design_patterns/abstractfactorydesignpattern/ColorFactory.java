package design_patterns.abstractfactorydesignpattern;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		Color color=null;
		if(colorType.equals("red")){
			color = new Red();
		}
		if(colorType.equals("yellow")){
			color = new Yellow();
		}
		return color;
	}

}
