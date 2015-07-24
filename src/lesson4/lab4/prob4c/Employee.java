package lesson4.lab4.prob4c;

public abstract class Employee {

	private int empId;
	
	//added to keep track date of paying check
	private int monthPayCheck;
	private int yearPayCheck;
	
	// Constructor
	public Employee(int emplId) {
		this.empId = emplId;
	}

	public void setMonthPayCheck(int month)
	{
		this.monthPayCheck = month;
	}
	public int getMonthPayCheck()
	{
		return this.monthPayCheck;
	}
	
	public void setYearPayCheck(int year)
	{
		this.yearPayCheck = year;
	}
	public int getYearPayCheck()
	{
		return this.yearPayCheck;
	}
	
	public int getEmpId()
	{
		return this.empId;
	}
	public void print() {
		
	}
	
	// Template function
	public Paycheck calcCompensation(int month, int year) {
		setMonthPayCheck(month);
		setYearPayCheck(year);
		double grossPay = calcGrossPay();
		Paycheck payCheck = new Paycheck(grossPay );
		return payCheck;
	}
	
	// delegate for asking specific someone performs 
	public abstract double calcGrossPay();
	
}
