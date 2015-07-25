package lesson5.lab5.prob2;

public class CannotFly implements FlyBehavior{

	@Override
	public void fly()
	{
		System.out.println("cannot fly");
	}
}
