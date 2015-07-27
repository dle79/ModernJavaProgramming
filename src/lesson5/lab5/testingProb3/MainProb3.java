package lesson5.lab5.testingProb3;

import java.util.ArrayList;
import java.util.List;

import lesson5.lab5.prob3.Circle;
import lesson5.lab5.prob3.Rectangle;
import lesson5.lab5.prob3.Shape;
import lesson5.lab5.prob3.Triangle;

public class MainProb3 {

	public static void main(String[] args) {
		List<Shape> arr = new ArrayList<Shape>();
		//Shape s = new Shape();
		arr.add(new Circle(4));
		arr.add(new Rectangle(13,18));
		arr.add(new Triangle(6,10));
		
		double sum = 0.00;
		double average = 0.00;
		if (arr.size() == 0) {
			average = 0;
		} else {
			for (Shape s : arr) {
				sum = sum + s.computeArea();
			}
			average = sum / arr.size();
		}

		System.out.printf("The avarage area of shapes is : %.2f", average);
	}

}
