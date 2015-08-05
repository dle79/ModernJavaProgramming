package lesson8.lab8.prob2.partA;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.name.equals(e2.name))
			return 0;
		
		return e1.name.compareTo(e2.name);
	}
}
