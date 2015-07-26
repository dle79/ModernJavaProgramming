package lesson5.lab5.prob2;

public class MallardDuck extends Duck{

	public MallardDuck()
	{
		super.flyBehavior = new FlyWithWings();
		super.quackBehavior = new Quack();
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
