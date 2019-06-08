package design_patterns.builderdesignpattern;

public class Computer {
private String HDD;
private String RAM;
private boolean bluetooth;
private boolean graphicsCard;

private Computer(ComputerBuilder computerBuilder){
	this.HDD = computerBuilder.HDD;
	this.RAM = computerBuilder.RAM;
	this.bluetooth = computerBuilder.bluetooth;
	this.graphicsCard = computerBuilder.graphicsCard;
}
public String getHDD() {
	return HDD;
}
public String getRAM() {
	return RAM;
}
public boolean isBluetooth() {
	return bluetooth;
}
public boolean isGraphicsCard() {
	return graphicsCard;
}

public static class ComputerBuilder{
	private String HDD;
	private String RAM;
	private boolean bluetooth;
	private boolean graphicsCard;
	
	public ComputerBuilder(String HDD, String RAM){
		this.HDD = HDD;
		this.RAM = RAM;
	}

	public ComputerBuilder setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
		return this;
	}

	public ComputerBuilder setGraphicsCard(boolean graphicsCard) {
		this.graphicsCard = graphicsCard;
		return this;
	}
	
	public Computer build(){
		return new Computer(this);
	}
}
}
