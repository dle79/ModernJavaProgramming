package lesson9.lab9.prob8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import quiz1.prob1.TriFunction;

public class Main {

	// print the number of Employees in list whose salary > 100000 and whose
	// last name begins
	// with a letter that comes after the letter 'E'

	public static final TriFunction<List<Employee>, String, Integer, Long> COUNT_EMPLOYEE_WITH_GIVEN_CONDITION = (
			list, letterToBePast, salaryToBePast) -> list
			.stream()
			.filter(e -> e.getLastName().substring(0, 1).toUpperCase()
					.hashCode() > letterToBePast.hashCode())
			.filter(e -> e.getSalary() > salaryToBePast).count();

	// print a list of sorted full names - all upper case -- of Employees with
	// salary > 85000 and whose first name begins with a letter that comes
	// before the letter 'R'

	public static final TriFunction<List<Employee>, String, Integer, List<String>> GET_LIST_OF_EMPLOYEE_WITH_GIVEN_CONDITION = (
			list, letterToBePast, salaryToBePast) -> list
			.stream()
			.filter(e -> e.getFirstName().substring(0, 1).toUpperCase()
					.hashCode() < letterToBePast.hashCode())
			.filter(e -> e.getSalary() > salaryToBePast)
			.map(e -> (e.getFirstName() + " " + e.getLastName()).toUpperCase())
			.sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("Joe", "Davis", 120000), 
				new Employee("John", "Sims", 110000),
				new Employee("Joe", "Stevens", 200000), 
				new Employee("Andrew", "Reardon", 80000), 
				new Employee("Joe", "Cummings", 760000), 
				new Employee("Steven", "Walters", 135000),
				new Employee("Thomas", "Blake", 111000), 
				new Employee("Alice", "Richards", 101000), 
				new Employee("Donald", "Trump", 100000));

		// print the number of Employees in list whose salary > 100000 and whose
		// last name begins
		// with a letter that comes after the letter 'E'
		System.out.println(COUNT_EMPLOYEE_WITH_GIVEN_CONDITION.apply(list, "E", 100000));
		
		// print a list of sorted full names - all upper case -- of Employees
		// with
		// salary > 85000 and whose first name begins with a letter that comes
		// before the letter 'R'
		System.out.println(GET_LIST_OF_EMPLOYEE_WITH_GIVEN_CONDITION.apply(list, "R", 85000));
	}

}
