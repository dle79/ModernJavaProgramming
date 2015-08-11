package lesson10.lab10.prob7.soln1;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import lesson10.lab10.prob7.Employee;
import lesson10.lab10.prob7.Main;

public class MainTest {

	@Test
	public void testAsString() {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
											new Employee("Tom", "Sink", 90000),
											new Employee("Peter", "Thomas", 200000),
											new Employee("Teddy", "Thomson", 200000));

		String expectedResult = "Peter Thomas, Teddy Thomson";
		Assert.assertEquals(expectedResult, Main.asString(emps));
	}
}
