package lesson5.lab5.prob2;

public class Main {
	public static void main(String args[])
	{
		Duck[] duck = new Duck[4];
		duck[0] = new MallardDuck();
		duck[1] = new DecoyDuck();
		duck[2] = new RedheadDuck();
		duck[3] = new RubberDuck();
		
		duck[0].setFlyBehavior(new FlyWithWings());
		duck[0].setQuackBehavior(new Quack());
		
		duck[1].setFlyBehavior(new CannotFly());
		duck[1].setQuackBehavior(new MuteQuack());

		duck[2].setFlyBehavior(new FlyWithWings());
		duck[2].setQuackBehavior(new Quack());

		duck[3].setFlyBehavior(new CannotFly());
		duck[3].setQuackBehavior(new Quack());
		
		for(Duck d : duck)
		{
			System.out.println(d.getClass().getSimpleName() + ":");
			d.display();
			d.fly();
			d.quack();
			d.swim();
		}

	}
}
