package lesson10.lab10.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lesson10.lab10.prob5.FunctionWithException.unchecked;

public class FixThisSoln {

	List<String> processList(List<String> list) {

		return list.stream().map(x -> unchecked((String str) -> doNothingIfShort(str)).apply(x)).map(Object::toString)
				.collect(Collectors.toList());

	}

	String doNothingIfShort(String input) throws InputTooLongException {
		if (input.length() > 3)
			throw new InputTooLongException();
		else
			return input;
	}

	public static void main(String[] args) {
		FixThisSoln ft = new FixThisSoln();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		System.out.println(ft.processList(words1));
	}

	class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;

		public InputTooLongException() {
			super("Must be length 3 or less");
		}

		public InputTooLongException(String s) {
			super(s);
		}

		public InputTooLongException(Throwable t) {
			super(t);
		}
	}

}
