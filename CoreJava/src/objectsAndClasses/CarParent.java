package objectsAndClasses;

public class CarParent {
	private int numberOfWheel;
	private String color;
	private String namePlate;
	CarParent (){
		this.numberOfWheel=4;
		this.color="Green";
		this.namePlate="DLCAM5578";
	}
	public String getColor() {
		return color;
		
	}
	public int getNumberOfWheel() {
		return numberOfWheel;
		
	}
	public String getNamePlat() {
		return namePlate;
		
	}
}
