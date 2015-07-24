package lesson4.lab4.prob4c;

public abstract class Employee {

	private int empId;
	
	//added to keep track date of paying check
	private int payCheckMonth;
	private int payCheckYear;
	
	// Constructor
	public Employee(int emplId) {
		this.empId = emplId;
	}

	// used only inside
	private void setMonthPayCheck(int month)
	{
		this.payCheckMonth = month;
	}
	public int getMonthPayCheck()
	{
		return this.payCheckMonth;
	}
	
	// used only inside
	private void setYearPayCheck(int year)
	{
		this.payCheckYear = year;
	}
	public int getYearPayCheck()
	{
		return this.payCheckYear;
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
