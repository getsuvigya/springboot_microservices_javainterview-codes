package design_patterns.abstractfactorydesignpattern;

public class AbstractFactoryPatternDemo {
 public static void main(String[] args) {
	 AbstractFactory factory1 = FactoryProducer.getFactory("shape");
	 Shape squareShape = factory1.getShape("square");
	 squareShape.draw();
	 Color color = FactoryProducer.getFactory("color").getColor("red");
	 color.fill();
}
}
