package lesson9.lab9.prob8;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {

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

}
