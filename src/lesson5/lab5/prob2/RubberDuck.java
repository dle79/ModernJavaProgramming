package lesson5.lab5.prob2;

public class RubberDuck extends Duck{

	public RubberDuck()
	{
		super.flyBehavior = new CannotFly();
		super.quackBehavior = new Squeak();
	}
	
	@Override
	public void fly()
	{
		super.flyBehavior.fly();	
	}
	
	@Override
	public void quack()
	{
		super.quackBehavior.quack();
	}
	
	@Override
	public void display()
	{
		System.out.println("displaying");
	}
	
}
