package DungLe.prob1;

import java.util.function.BiFunction;

import prob1.SampleProblem1.BiFunc;

//work with this lambda expression:   (Double x, Double y) -> x * y < x + y
public class Problem1 {
	// name and type of lambda goes here
	BiFunction<Double, Double, Boolean> bifunction = (x, y) -> x * x < y + y;

	// representing lambda as a method refrence
	BiFunction<Double, Double, Boolean> bifunction2 = Problem1::sumSquares;

	// representing lambda as a static nested class
	static class BiFunc implements BiFunction<Double, Double, Boolean> {
		public Boolean apply(Double x, Double y) {
			return x * x < y + y;
		}
	}

	private static boolean sumSquares(double x, double y) {
		return x * x < y + y;
	}

	// evaluate with Double inputs 2.1, 0.35
	public void evaluator() {
		System.out.println(bifunction.apply(2.0, 7.0));
		System.out.println(bifunction2.apply(2.0, 7.0));
		System.out.println((new BiFunc()).apply(2.0, 7.0));

	}

	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.evaluator();
	}

}
