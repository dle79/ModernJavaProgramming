package lesson5.lab5.prob3;

final public class Triangle implements Shape{
	private double base;
	private double height;
	
	public Triangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	
	public double getBase(){
		return base;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double computeArea(){
		return base*height/2;
	}
}
