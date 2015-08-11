package lesson10.lab10.prob1;

import java.util.List;
import java.util.stream.Collectors;

public class TDDPractice {

	public static List<String> changeLastCharToUpper(List<String> words) {
		return words.stream().map(TDDPractice::lastCharToUpper)
				.collect(Collectors.toList());
	}

	public static String lastCharToUpper(String value) {
		char lastChar = Character.toUpperCase(value.charAt(value.length() - 1));
		return value.substring(0, value.length() - 1) + lastChar;
	}
}
