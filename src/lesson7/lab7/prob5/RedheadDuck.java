package lesson7.lab7.prob5;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}
	@Override
	public void display() {
		System.out.println("  displaying");
		
	}
}
