package lesson5.lab5.prob2;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
//	public void setFlyBehavior(FlyBehavior flyBehavior)
//	{
//		this.flyBehavior = flyBehavior;
//	}
//	public void setQuackBehavior(QuackBehavior quackBehavior)
//	{
//		this.quackBehavior = quackBehavior;
//	}
	
	public abstract void fly();
//	{
//		flyBehavior.fly();
//	}
	public abstract void quack();
//	{
//		quackBehavior.quack();
//	}
	public abstract void display();
	
	public void swim()
	{
		System.out.println("swimming");
	}
	
	
}
