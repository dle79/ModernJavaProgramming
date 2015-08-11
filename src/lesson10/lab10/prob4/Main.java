package lesson10.lab10.prob4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		UpdateCustomer rc = new UpdateCustomer();
		
		try {
			//prob 4A
			rc.updateZips();					
			List<Customer> custs = new ArrayList<Customer>(); 
			custs.add(new Customer("Billy","11 Channing Ave","Palo Alto", "94301"));
			custs.add(new Customer("Billy","11 Channing Ave","Palo Alto", "94301"));
			custs.add(new Customer("Billy1","11 Channing Ave","Palo Alto", "54301"));
			//prob 4B
			rc.insertCustomer(custs);
			
		} catch(SQLException e) {
			for(Throwable t : e) {
				System.out.println("* " + t.getMessage());
			}
		}

	}
}
