package lesson4.lab4.prob4c;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Commissioned extends Employee{
	private double commission;
	private double baseSalary;
	private List<Order> orders = new ArrayList<Order>();
	
	// Constructor
	public Commissioned(Commissioned obj)
	{
		super(obj.getEmpId());
		this.commission = obj.getCommision();
		this.baseSalary = obj.getBaseSalary();
		this.orders = obj.getOrders();
	}
	public Commissioned(int empId, double commission, double baseSalary)
	{
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
	}
	
	public double getCommision()
	{
		return this.commission;
	}
	public double getBaseSalary()
	{
		return this.baseSalary;
	}
	
	public List<Order> getOrders()
	{
		return this.orders;
	}
	public void addOrder(Order order)
	{
		orders.add(order);
	}
	@Override
	public double calcGrossPay()
	{
		double totalOrderPreviousMonth = 0.0;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, this.getMonthPayCheck() -1);
		calendar.add(Calendar.YEAR, this.getYearPayCheck());
		
		int previousMonth = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		
		for(Order order : this.orders)
		{
			Date date = order.getOrderDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			if(cal.get(Calendar.MONTH) == previousMonth && cal.get(Calendar.YEAR) == year)
			{
				totalOrderPreviousMonth += order.getOrderAmount();
			}
		}
		double grossPay = baseSalary + commission * totalOrderPreviousMonth;
		return grossPay;
	}
	@Override
	public void print()
	{
		System.out.println("Info Commissioned Employee " + getEmpId() + "-------------");
		System.out.println("\t\t Commission:" + commission);
		System.out.println("\t\t Base Salary:" + baseSalary);
		System.out.println("\t\t Gross Salary:" + calcGrossPay());
	}
}
