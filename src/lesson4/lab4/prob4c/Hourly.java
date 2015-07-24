package lesson4.lab4.prob4c;

public class Hourly extends Employee{
	
	private static final int WEEK_IN_MONTH = 4;
	private double hourlyWage;
	private int hoursPerWeek;
	
	public Hourly(int empId, double hourlyWage, int hoursPerWeek)
	{
		super(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	
	@Override
	public double calcGrossPay() {
		double grossPay = hourlyWage * hoursPerWeek * WEEK_IN_MONTH;
		return grossPay;
	}
	
	@Override
	public void print()
	{
		System.out.println("Info Hourly Employee " + getEmpId() + "-------------");
		System.out.println("\t\t Hourly Wage:" + hourlyWage);
		System.out.println("\t\t Hours Per Week:" + hoursPerWeek);
		System.out.println("\t\t Gross Salary:" + calcGrossPay());
	}
}
