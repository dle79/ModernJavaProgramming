package lesson5.lab5.prob3;

final public class Rectangle implements Shape {
	
	private double width;
	private double length;
	
	public Rectangle(double width, double length){
		this.width = width;
		this.length = length;
	}
	
	public double computeArea() {
		return width*length;
	}

	public double getHeight(){
		return length;
	}

	public double getWidth() {
		return width;
	}
}
