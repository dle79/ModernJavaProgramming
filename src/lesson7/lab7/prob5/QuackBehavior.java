package lesson7.lab7.prob5;

public interface QuackBehavior {
	default void quack(){
		System.out.println(" quacking");
	}
}
