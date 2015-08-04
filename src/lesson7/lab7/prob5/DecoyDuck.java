package lesson7.lab7.prob5;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new CannotFly());
	}
	@Override
	public void display() {
		System.out.println("  displaying");
		
	}
}
