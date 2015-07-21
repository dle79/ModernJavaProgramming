package lesson2.prob2b;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OrderLine> arr = new ArrayList<OrderLine>();
		arr.add(new OrderLine("Samsung laptop", 2));
		arr.add(new OrderLine("Iphone 6", 5));
		Order order1 = new Order(1, arr);		
	}

}
