package lesson9.lab9.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class EmployeeInfoBetter {
	static enum SortMethod {BYNAME, BYSALARY};
	Function<Employee, String> byName = e -> e.getName();
	Function<Employee, Integer> bySalary = e -> e.getSalary();
	
	Comparator<Employee> byNameComparator = Comparator.comparing(byName).thenComparing(bySalary);
	Comparator<Employee> bySalaryComparator = Comparator.comparing(bySalary).thenComparing(byName);
	
	@SuppressWarnings("serial")
	HashMap<EmployeeInfoBetter.SortMethod, Comparator<Employee>> map = new HashMap<EmployeeInfoBetter.SortMethod, Comparator<Employee>>(){
		{
			put(SortMethod.BYNAME, byNameComparator);
			put(SortMethod.BYSALARY, bySalaryComparator);
		}
	};	
	
	public void sort(List<Employee> emps, final SortMethod method) {
		Collections.sort(emps,map.get(method));							
	}
		
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		EmployeeInfoBetter ei = new EmployeeInfoBetter();
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYSALARY);
		//System.out.println(emps);
	}
}
