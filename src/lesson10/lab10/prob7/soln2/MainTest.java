package lesson10.lab10.prob7.soln2;

import org.junit.Assert;
import org.junit.Test;

import lesson10.lab10.prob7.Employee;

public class MainTest {

	@Test
	public void testSalaryGreaterThan100000True() {
		Employee e = new Employee("Joe", "Davis", 120000);
		Assert.assertTrue(Main.salaryGreaterThan100000(e));
	}

	@Test
	public void testSalaryGreaterThan100000False() {
		Employee e = new Employee("John", "Snow", 80000);
		Assert.assertFalse(Main.salaryGreaterThan100000(e));
	}

	@Test
	public void testLastNameAfterMTrue() {
		Employee e = new Employee("Donald", "Trump", 100000);
		Assert.assertTrue(Main.lastNameAfterM(e));
	}

	@Test
	public void testLastNameAfterMFalse() {
		Employee e = new Employee("Joe", "Davis", 120000);
		Assert.assertFalse(Main.lastNameAfterM(e));
	}

	@Test
	public void testFullName() {
		Employee e = new Employee("Donald", "Trump", 100000);
		Assert.assertEquals("Donald Trump", Main.fullName(e));
	}
}
