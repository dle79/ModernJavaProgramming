package lesson11.lab11.prob5;

import java.util.List;

public class  GenericFunction {

	public static <T extends Comparable<T>> T findSecondSmallest(List<T> list)
	{
		T firstSmallest = list.get(0);
		T secondSmallest = list.get(1);
		for(T t : list)
		{
			if(firstSmallest.compareTo(t) >  0)
			{
				secondSmallest = firstSmallest;
				firstSmallest = t;
			}
			else if(secondSmallest.compareTo(t) > 0 && firstSmallest.compareTo(t) < 0)
			{
				secondSmallest = t;
			}
		}
		return secondSmallest;
	}
	
}
