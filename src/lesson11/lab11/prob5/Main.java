package lesson11.lab11.prob5;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[])
	{
		List<Integer> list = Arrays.asList(1000000333,744444444,1000000334,1000000331,1000000633,1000000933,1000000315);
		System.out.println("Second Smallest in list is:" + GenericFunction.findSecondSmallest(list));
	}
}
