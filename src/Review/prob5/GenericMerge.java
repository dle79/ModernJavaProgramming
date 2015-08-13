package Review.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericMerge {

	public static <T,S> List<?> merge(List<? extends T> list1, List<? extends S> list2, 
			BiComparator<? super T, ? super S> comp)
	{
		List<Object> result = new ArrayList<>(list1.size() + list2.size());
		int i = 0, j = 0;
		
		while(i < list1.size() && j < list2.size())
		{
			if(comp.compare(list1.get(i), list2.get(j)) <= 0)
			{
				result.add(list1.get(i++));
			}
			else
			{
				result.add(list2.get(j++));
			}
		}
		while(i < list1.size())
		{
			result.add(list1.get(i++));
		}
		while(j < list2.size())
		{
			result.add(list2.get(j++));
		}
		return result;
	}
	
	private static final BiComparator<Integer, Integer> compByIntInt = new BiComparator<Integer, Integer>() {
		
		@Override
		public int compare(Integer o1Int, Integer o2Int) {
			
			return o1Int - o2Int;
		}
	};
	
	private static final BiComparator<Integer, String> compByIntString = new BiComparator<Integer, String>() {
		
		@Override
		public int compare(Integer o1Int, String o2Str) {
			
			if(o1Int >= o2Str.length())
			{
				return 1;
			}
			return o1Int - o2Str.length();
		}
	};
	
	private static final BiComparator<String, String> compByStringString = new BiComparator<String, String>() {
		
		@Override
		public int compare(String o1Str, String o2Str) {
			
			return o1Str.compareTo(o2Str);
		}
	};

	private static final BiComparator<Double, Number> compByDoubleNumber = new BiComparator<Double, Number>() {
		
		@Override
		public int compare(Double o1Double, Number o2Number) {
			
			if(o1Double > o2Number.doubleValue())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	};
	
	private static final BiComparator<String, Person> compByStringPerson = new BiComparator<String, Person>() {
		
		@Override
		public int compare(String t, Person s) {
			return t.compareTo(s.getName());
		}
	};

	public static void main(String args[])
	{
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("Alice", "Tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");
		
		List<Person> listPerson = new ArrayList<Person>() {
			{
				add(new Person("Jim", 40));
				add(new Person("Tom", 25));
				add(new Person("Bill", 30));
				add(new Person("Rich", 35));
				add(new Person("Anna", 20));
				add(new Person("Ricardo",17));
				add(new Person("Jimenez", 26));
				add(new Person("Jesus", 45));
				add(new Person("Michelle", 30));
				add(new Person("Angelina", 33));
				add(new Person("Julio", 49));
				add(new Person("Andrew", 34));
			}
		};
		Collections.sort(listPerson, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println(GenericMerge.merge(list1, list2, GenericMerge.compByIntInt));
		System.out.println(GenericMerge.merge(list3, list4, GenericMerge.compByStringString));
		System.out.println(GenericMerge.merge(list5, list6, GenericMerge.compByDoubleNumber));
		System.out.println(GenericMerge.merge(list1, list7, GenericMerge.compByIntString));
		System.out.println(GenericMerge.merge(list3, listPerson, GenericMerge.compByStringPerson));
	}
}
