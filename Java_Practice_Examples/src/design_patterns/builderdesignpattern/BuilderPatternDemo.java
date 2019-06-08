package design_patterns.builderdesignpattern;

public class BuilderPatternDemo {
public static void main(String[] args) {
	Computer graphicsCardEnabledComp = (new Computer.ComputerBuilder("1TB", "16GB").setGraphicsCard(true)).build();
	System.out.println(graphicsCardEnabledComp.isGraphicsCard());
}
}
