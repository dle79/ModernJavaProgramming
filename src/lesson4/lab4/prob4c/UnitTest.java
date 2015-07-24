package lesson4.lab4.prob4c;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testHourlyEmployee() {
		Employee emp = new Hourly(1, 40.0, 40);
		double expectedGrossSalary = 40.0 * 40 * 4;
		double grossSalary = emp.calcGrossPay();
		
		assertTrue(expectedGrossSalary == grossSalary);
		
		Paycheck payCheck = emp.calcCompensation(7, 2015);
		double expectedNetSalary = grossSalary - grossSalary * payCheck.getTotalTax();
		double netSalary = payCheck.getNextPay();
		
		assertTrue(expectedNetSalary == netSalary);
		
	}
	@Test
	public void testSalariedEmployee() {
		Employee emp = new Salaried(1,100.0);
		double expectedGrossSalary = 100.0;
		double grossSalary = emp.calcGrossPay();
		
		assertTrue(expectedGrossSalary == grossSalary);
		
		Paycheck payCheck = emp.calcCompensation(7, 2015);
		double expectedNetSalary = grossSalary - grossSalary * payCheck.getTotalTax();
		double netSalary = payCheck.getNextPay();
		
		assertTrue(expectedNetSalary == netSalary);
	}
	@Test
	public void testCommissionedEmployee() {
		
		Commissioned comEmp = new Commissioned(3, 10.0, 20.0);
		Date date = new GregorianCalendar(2015, Calendar.DECEMBER, 11).getTime();
		comEmp.addOrder(new Order(3, date, 5.0) );
		
		Employee emp = new Commissioned(comEmp);
		
		Paycheck payCheck = emp.calcCompensation(1, 2016);
		double grossSalary = emp.calcGrossPay();
		double expectedNetSalary = grossSalary - grossSalary * payCheck.getTotalTax();
		double netSalary = payCheck.getNextPay();
		
		assertTrue(expectedNetSalary == netSalary);

	}

}
