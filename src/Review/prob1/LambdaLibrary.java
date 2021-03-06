package Review.prob1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {

	/*
	 * Query A: Given a member's checkout record, determine whether some BookCopy in the record is overdue. 
	 * NOTE: A BookCopy is overdue if
	(a) it is not available, and
	(b) its due date is before now
	*/
	static final Function<CheckoutRecord, Boolean> QUERY_A = (record) ->
	!record.getCheckoutEntries().stream()
	.filter(recordEntry -> ! recordEntry.getCopy().isAvailable())
	.filter(recordEntry -> recordEntry.getDueDate().compareTo(LocalDate.now()) < 0)
	.collect(Collectors.toList()).isEmpty();
	
	static final Function<CheckoutRecord, Boolean> HAS_OVERDUE = (record) ->
	record.getCheckoutEntries().stream()
	.map(e -> !e.getCopy().isAvailable() && e.getDueDate().isBefore(LocalDate.now()))
	.reduce(false, (a,b) -> a || b);
	
	/*
	 * Query B: Given a BookCopy copy and a LibraryMember mem, 
	 * return true if mem has ever checked out this copy
	 * 
	 * */
	static final BiFunction<BookCopy, LibraryMember, Boolean> QUERY_B = (bc, lm) ->
	!lm.getRecord().getCheckoutEntries().stream()
	.filter(recordEntry -> recordEntry.getCopy().getBook().getIsbn().equals(bc.getBook().getIsbn()))
	.collect(Collectors.toList()).isEmpty();
	
	static final BiFunction<BookCopy, LibraryMember, Boolean> EVER_CHECKED_OUT = (bc, lm) ->
	lm.getRecord().getCheckoutEntries().stream()
	.filter(e -> e.getCopy().getBook().getIsbn().equals(bc.getBook().getIsbn()) 
			&& e.getCopy().getCopyNumber() == bc.getCopyNumber())
	.findAny()
	.isPresent();
	
	/*
	 * Query C: Given a list of all library members, return a list, in reverse sorted order (by first name), 
	 * of the full names (first name + <space> + last name) of those library members who 
	 * have never checked out a book
	 * */
	static final Function<List<LibraryMember> , List<String> > QUERY_C = (list) ->
	list.stream()
	.filter(lm -> lm.getRecord().getCheckoutEntries().isEmpty())
	.sorted(Comparator.comparing(LibraryMember::getFirstName).reversed())
	.map(lm -> lm.getFirstName() + " " + lm.getLastName()).collect(Collectors.toList());
	
	static final Function<List<LibraryMember>, List<String> > INACTIVE_MEMBERS = (list) ->
	list.stream()
	.filter(mem -> mem.getRecord().getCheckoutEntries().isEmpty())
	.sorted(Comparator.comparing((LibraryMember mem) -> mem.getFirstName()).reversed())
	.map(mem -> mem.getFirstName() + " " + mem.getLastName())
	.collect(Collectors.toList());
	
}
