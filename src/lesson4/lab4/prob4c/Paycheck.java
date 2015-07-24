package lesson4.lab4.prob4c;

//import java.util.Date;

public class Paycheck {
	
	private static final double FICA_TAX	=	0.23;
	private static final double STATE_TAX	=	0.05;
	private static final double LOCAL_Tax	=	0.01;
	private static final double MEDICARE_TAX =  0.03;
	private static final double SOCIAL_SECURITY_TAX = 0.075;
	private double grossPay;
	// Constructor
	public Paycheck(double grossPay)
	{
		this.grossPay = grossPay;
	}

	
	// getter
	public double getGrossPay()
	{
		return this.grossPay;
	}
	public double getFica()
	{
		return FICA_TAX;
	}
	public double getStateTax()
	{
		return STATE_TAX;
	}
	public double getLocalTax()
	{
		return LOCAL_Tax;
	}
	public double getMedicare()
	{
		return MEDICARE_TAX;
	}
	public double getSocialSecurity()
	{
		return SOCIAL_SECURITY_TAX;
	}

	public double getTotalTax()
	{
		return (FICA_TAX + STATE_TAX + LOCAL_Tax + MEDICARE_TAX + SOCIAL_SECURITY_TAX);
	}
	public void print() {
		
	}
	
	public double getNextPay() {
		double netPay = grossPay - grossPay * (FICA_TAX + STATE_TAX + LOCAL_Tax + MEDICARE_TAX + SOCIAL_SECURITY_TAX);
		return netPay;
	}
}
