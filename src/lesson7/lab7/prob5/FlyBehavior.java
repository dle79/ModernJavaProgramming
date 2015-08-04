package lesson7.lab7.prob5;

public interface FlyBehavior {
	default void fly(){
		System.out.println("  fly with wings");
	}
//	public void fly();
}
