package Review.prob2;

import java.util.function.Supplier;

//The lambda:   () -> Math.random()
public class PartA {
	// provide a functional interface type for the lambda
	Supplier<Double> random = () -> Math.random();

	// provide a method reference and the type of method reference
	// TYPE: class::staticMethod
	Supplier<Double> random2 = Math::random;

	// provide an inner class that behaves the same way as the lambda
	// class MyClass implements ... { }
	class MyRandom implements Supplier<Double> {
		@Override
		public Double get() {
			return Math.random();
		}
	}

	public void evaluator() {
		// implement the lambda, the method reference, and the inner class
		// operation
		System.out.println(random.get());
		System.out.println(random2.get());
		System.out.println(new MyRandom().get());
	}

	public static void main(String[] args) {
		PartA pa = new PartA();
		pa.evaluator();
	}
}
