package lesson11.lab11.prob2;

import java.util.ArrayList;
import java.util.List;

public class prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(25);
		ints.add(12);
		ints.add(3);
		System.out.println("before: " + ints);
		reverse(ints);
		System.out.println("after: " + ints);
		
	}

	public static  void reverse(List<?> list){
		reverseHelper(list);
	}
	private static <T> void reverseHelper(List<T> list){
		int size = list.size();
		for(int i = 0; i<size/2; i++){
			T t = list.get(i);
			list.set(i, list.get(size - 1 - i));
			list.set(size - 1 - i, t);
		}
	}
	
}
