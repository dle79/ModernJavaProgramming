package lesson5.lab5.prob2;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	
	public abstract void fly();
	public abstract void quack();
	public abstract void display();
	
	public void swim()
	{
		System.out.println("swimming");
	}
	
	
}
