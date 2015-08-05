package lesson8.lab8.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForEachExample_MethodRef {
	Function<String, String> toUpper = String::toUpperCase;
	Consumer<String> printUpper = System.out::println;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		ForEachExample_MethodRef f = new ForEachExample_MethodRef();
		list.stream().map(f.toUpper).forEach(f.printUpper);
	}			
}