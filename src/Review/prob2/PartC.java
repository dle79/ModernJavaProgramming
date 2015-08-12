package Review.prob2;

import java.util.Comparator;

//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	Comparator<Long> max = (Long a,Long b) -> a.compareTo(b);
	
	//provide a method reference and the type of method reference
	//TYPE: 
	Comparator<Long> max2 = Long::compareTo;
	
	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class MyMax implements Comparator<Long> {

		
		@Override
		public int compare(Long o1, Long o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
	}
		
	
	public void evaluator() {
		System.out.println(max.compare(30L, 20L));
		System.out.println(max2.compare(3L,2L));
		System.out.println(new MyMax().compare(20L, 20L));
	}
	
	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}
