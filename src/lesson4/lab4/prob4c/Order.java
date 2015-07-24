package lesson4.lab4.prob4c;

import java.util.Date;

public class Order {
	private int orderNo;
	private Date orderDate;
	private double orderAmount;
	
	// Constructor
	public Order(int orderNo, Date orderDate, double orderAmount)
	{
		if (orderAmount <= 0) {
			throw new IllegalArgumentException("Order amount can't be negative");
		}
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	
	public int getOrderNo()
	{
		return this.orderNo;
	}
	public Date getOrderDate()
	{
		return this.orderDate;
	}
	
	public double getOrderAmount()
	{
		return this.orderAmount;
	}
}
