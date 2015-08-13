package review1.prob6;

import java.util.function.Predicate;
import java.util.*;
public class ConditionalRemove {
	
	
	static class StrLengthCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.length() == 5;
		}
	}
	
	static class StrContainKCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.contains("k");
		}
	}
	
	static class EmployeeSalaryCondition implements Predicate<Employee> {
		public boolean test(Employee s) {
			return s.getSalary() < 60000;
		}
	}
	
	static class IntegerCondition implements Predicate<Integer> {
		public boolean test(Integer s) {
			return s > 100;
		}
	}
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Hello");add("Goodbye");
			}
		};
		
		ArrayList<String> listK = new ArrayList<String>() {
			{
				add("Hello");add("Gokodbye");
			}
		};
		
		ArrayList<Employee> listEmployee = new ArrayList<Employee>();
		listEmployee.add(new Employee("Corroza", 200.000));
		listEmployee.add(new Employee("khuong", 60.000));
		
		ArrayList<Integer> listInt = new ArrayList<Integer>() {
			{
				add(30);add(200);add(330);add(60);
			}
		};
			
		System.out.println(conditionalRemove(list, new StrLengthCondition()));
		//System.out.println(conditionalRemove(listK, new StrContainKCondition()));
		System.out.println(conditionalRemove(listEmployee, new EmployeeSalaryCondition()));
		//System.out.println(conditionalRemove(listInt, new IntegerCondition()));
	}

	
	public static <T> List<T> conditionalRemove(ArrayList<T> list, Predicate<T> byCond) {
	
		for (T s : list) {
			if (byCond.test(s)) {
				list.remove(s);
			}
		}
		return list;
	}
}
