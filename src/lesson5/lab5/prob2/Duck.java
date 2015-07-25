package lesson5.lab5.prob2;

public abstract class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public void setFlyBehavior(FlyBehavior flyBehavior)
	{
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior)
	{
		this.quackBehavior = quackBehavior;
	}
	
	public void fly()
	{
		flyBehavior.fly();
	}
	public void quack()
	{
		quackBehavior.quack();
	}
	
	public void swim()
	{
		System.out.println("swimming");
	}
	
	public abstract void display();
}
