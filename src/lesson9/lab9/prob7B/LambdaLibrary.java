package lesson9.lab9.prob7B;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	static final Consumer<List<Employee>> PRINT_EMPL = list ->
		System.out.println(
		list.stream().sorted(Comparator.comparing(Employee::getFirstName) )
		.map(e -> e)
		.filter(e -> e.getSalary() > 100000)
		.filter(e -> e.getLastName().charAt(0) >= 'N' && e.getLastName().charAt(0) <= 'Z')
		.map(e -> (e.getFirstName() + " " + e.getLastName()).toString())
		.collect(Collectors.joining(", "))
		
		);
}
