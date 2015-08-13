package DungLe.prob2;

import helperclasses.CheckoutRecordEntry;
import helperclasses.TestData;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/*
 * Print to the console the list of book Title – in sorted order -- 
 * in which the book has been checked out on June 27, 2015. 
 * The ordering of the book title is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		// use this list
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();	
		System.out.println(list.stream()
				.filter(new CheckOutDate())
				.sorted(Comparator.comparingInt((CheckoutRecordEntry c) -> c.getCopy().getBook().getTitle().length())
								.thenComparing((CheckoutRecordEntry c) -> c.getCopy().getBook().getTitle()))
				.map(c -> c.getCopy().getBook().getTitle())
				.collect(Collectors.toList()));
		
		
	}
	static class CheckOutDate implements Predicate<CheckoutRecordEntry> {
		public boolean test(CheckoutRecordEntry c) {
			return c.getCheckoutDate().getYear() == 2015 
					&& c.getCheckoutDate().getMonthValue() == 6 
					&& c.getCheckoutDate().getDayOfMonth() == 27;					
		}
	}
	

	
}
