package Review.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Merge <T, E> {

	private List<Integer> cashInt = new ArrayList<Integer>();

	/* For testing your implementation */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Merge myMerge = new Merge();
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("Alice", "Tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");

		List<? super Integer> merge12 = myMerge.merge(list1, list2);
		List<? super String> merge34 = myMerge.merge(list3, list4);
		List<? super Number> merge56 = myMerge.merge(list5, list6);
		List<? super Object> merge17 = myMerge.merge(list1, list7);
		System.out.println(merge12);
		System.out.println(merge34);
		System.out.println(merge56);
		System.out.println(merge17);
	}

	@SuppressWarnings("unchecked")
	public <T, E> List<T> merge( Collection<? extends T> list1, Collection<? extends T>  list2)
	{
		List<T> result = new ArrayList<T>();
		Iterator<T> it1 = (Iterator<T>) list1.iterator();
		Iterator<T> it2 = (Iterator<T>) list2.iterator();
		while(it1.hasNext() || it2.hasNext())
		{
			T t1 = null;
			if(it1.hasNext())
				t1 = it1.next();
			
			T t2 = null;
			if(it2.hasNext())
				t2 = it2.next();
			
			if(t1 != null && t2 != null)
			{
				int comp = compare(t1, t2 );
				if(comp > 0 && cashInt.size() == 0)
				{
					result.add((T) t2);
					result.add((T) t1);
				}
				else if(comp < 0 && cashInt.size() == 0)
				{
					result.add((T) t1);
					result.add((T) t2);
				}
				else if(comp > 0 && cashInt.size() > 0)
				{
					if(compareWithoutCash(t2, cashInt.get(0) ) > 0)
					{
						result.add((T) cashInt.remove(0));
						result.add((T) t2);
					}
					else
					{
						result.add((T) t2);
					}
				}
				else if(comp < 0 && cashInt.size() > 0)
				{
					if(compareWithoutCash(t1, cashInt.get(0) ) > 0)
					{
						result.add((T) cashInt.remove(0));
						result.add((T) t1);
					}
					else
					{
						result.add((T) t1);
					}
				}
				
			}
			else if(t1 != null && t2 == null)
			{
				result.add((T) t1);
			}
			else if(t1 == null && t2 != null)
			{
				result.add((T) t2);
			}
		}

		if(cashInt.size() > 0)
		{
			result.addAll((Collection<? extends T>) cashInt);
		}
		return result;
	}
		
	public int compare(Object o1, Object o2)
	{
		if(o1.getClass() == String.class && o2.getClass() == String.class)
		{
			String o1Str = (String) o1;
			String o2Str = (String) o2;
			return o1Str.compareTo(o2Str);
		}
		else if(o1.getClass() == Integer.class && o2.getClass() == Integer.class)
		{
			Integer o1Int = (Integer) o1;
			Integer o2Int = (Integer) o2;
			return o1Int - o2Int;
		}
		else if(o1.getClass() == String.class && o2.getClass() == Integer.class)
		{
			String o1Str = (String) o1;
			Integer o2Int = (Integer) o2;
			if(o1Str.length() <= o2Int)
			{
				cashInt.add(o2Int);
				return -1;
			}
			return o1Str.length() - o2Int;
		}
		else if(o1.getClass() == Integer.class && o2.getClass() == String.class)
		{
			Integer o1Int = (Integer) o1;
			String o2Str = (String) o2;
			if(o1Int >= o2Str.length())
			{
				cashInt.add(o1Int);
				return 1;
			}
			return o1Int - o2Str.length();
		}
		else if(o1 instanceof Number && o2 instanceof Number)
		{
			Number n1 = (Number)o1;
			Number n2 = (Number)o2;
			if(n1.doubleValue() > n2.doubleValue())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		return -1;
	}
	
	public int compareWithoutCash(Object o1, Object o2)
	{
		if(o1.getClass() == String.class && o2.getClass() == Integer.class)
		{
			String o1Str = (String) o1;
			Integer o2Int = (Integer) o2;

			return o1Str.length() - o2Int;
		}
		else if(o1.getClass() == Integer.class && o2.getClass() == String.class)
		{
			Integer o1Int = (Integer) o1;
			String o2Str = (String) o2;
			return o1Int - o2Str.length();
		}
		return -1;
	}
}