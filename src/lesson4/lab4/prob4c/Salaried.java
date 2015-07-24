package lesson4.lab4.prob4c;

public class Salaried extends Employee{
	
	// fixed salary for each month
	private double salary;
	
	// Constructor
	public Salaried(int empId, double salary)
	{
		super(empId);
		this.salary = salary;
	}
	
	@Override
	public double calcGrossPay()
	{
		return this.salary;
	}
	
	@Override
	public void print()
	{
		System.out.println("Info Salaried Employee " + getEmpId() + "-------------");
		System.out.println("\t\t Gross Salary:" + calcGrossPay());
	}
}
