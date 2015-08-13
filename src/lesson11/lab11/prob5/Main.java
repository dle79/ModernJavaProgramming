package lesson11.lab11.prob5;

import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String args[])
	{
		List<Integer> list = Arrays.asList(4,7,3,75,9,34,25);
		System.out.println("Second Smallest in list is:" + GenericFunction.findSecondSmallest(list));
		
		List<Person> testPerson = Arrays.asList(new Person("Jim", 40), new Person("Tom", 25)
		, new Person("Bill", 30), new Person("Rich", 35), new Person("Anna", 20), new Person("Ricardo",17),
				new Person("Jimenez", 26), new Person("Jesus", 45), new Person("Michelle", 30), 
				new Person("Angelina", 33), new Person("Julio", 49), new Person("Andrew", 34)) ;
				
		System.out.println("Second Smallest in Person list is:" + 
		GenericFunction.findSecondSmallest(testPerson));
	}
}
