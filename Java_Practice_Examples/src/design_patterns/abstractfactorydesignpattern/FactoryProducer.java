package design_patterns.abstractfactorydesignpattern;

public class FactoryProducer {
	public static AbstractFactory factory;
	public static AbstractFactory getFactory(String factoryType){
		if(factoryType.equals("color")){
			factory = new ColorFactory();
		}
		if(factoryType.equals("shape")){
			factory = new ShapeFactory();
		}
		
		return factory;
	}
}
