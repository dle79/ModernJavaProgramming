package DungLe.prob3;

import helperclasses.Book;
import helperclasses.CheckoutRecord;
import helperclasses.LibraryMember;
import helperclasses.LibrarySystemException;
import helperclasses.TestData;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;




public class Problem3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		p.books = TestData.INSTANCE.getAllBooks().iterator();
		p.detectIfWinnerDuringCheckout(members);
	}

	Iterator<Book> books;

	public LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems)  {
//		return null;
		//fix this
		return mems.stream()
					.filter(s -> PredicateWithException.
		          unchecked((LibraryMember m) -> checkNumCheckoutRecordEntries(m)).test(s))				         
		    .findFirst().orElse(null);
		
	}

	private boolean checkNumCheckoutRecordEntries(LibraryMember m)
			throws LibrarySystemException {
		boolean isIllegal = (m.checkout(books.next().getNextAvailableCopy(), 
		        				  LocalDate.now(), LocalDate.of(2015, 9, 1)).
		        				  getCheckoutRecordEntries().size() == 10);
		if (isIllegal)
			throw new LibrarySystemException(
					String.format(" This member has just checked out his 10th book"));
		else
			return true;
	}

}
