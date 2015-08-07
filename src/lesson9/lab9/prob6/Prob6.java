package lesson9.lab9.prob6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob6 {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("A");
		set1.add("B");
		Set<String> set2 = new HashSet<>();
		set2.add("D");
		Set<String> set3 = new HashSet<>();
		set3.add("1");
		set3.add("3");
		set3.add("5");
		List<Set<String>> list = new ArrayList<>();
		list.add(set1);
		list.add(set2);
		list.add(set3);

		System.out.println(new Prob6().union(list));
	}

	public Set<String> union(List<Set<String>> sets) {
		return sets.stream().reduce((x, y) -> {
			x.addAll(y);
			return x;
		}).get();
	}

}
