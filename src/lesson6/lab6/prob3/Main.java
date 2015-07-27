package lesson6.lab6.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
	private static final String NAME = "name";
	private static final String STREET = "street";
	private static final String CITY = "city";
	private static final String ZIP = "zip";

	// Use the DomServiceClass to get all customers
	// whose city of residence begins with "Ma", in sorted order.
	// Create
	public List<Customer> allCustomersBeginWithMa() {
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			System.out.println(System.getProperty("user.dir") + "/src/lesson6/labs/prob3/customer.xml");
			DomInterface xml = new DomServiceClass(System.getProperty("user.dir") + "/src/lesson6/labs/prob3/customer.xml");			

			List<Properties> propertyList = new ArrayList<Properties>();
			propertyList = xml.lookupEntry(CITY, "Ma");

			Customer customer = null;
			for (Properties prop : propertyList) {
				customer = new Customer(prop.getProperty(NAME),
										prop.getProperty(STREET), 
										prop.getProperty(CITY),
										prop.getProperty(ZIP));
				customerList.add(customer);
			}

		} catch (DomException de) {
			System.out.println(de.getMessage());
		}
		return customerList;
	}

	public static void main(String[] args) {
		Main m = new Main();
		List<Customer> list = m.allCustomersBeginWithMa();
		System.out.println(list);

	}

}
