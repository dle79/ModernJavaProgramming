package lesson8.lab8.prob6;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Prob6 {
	Function<String, String> toUpper1 = (String x) -> x.toUpperCase();
	Function<String, String> toUpper2 = String::toUpperCase;
//	A. (Employee e) -> e.getName()
	// type: Class::instanceMethod
	Function<Employee, String> getName1 = (e) -> e.getName();
	Function<Employee, String> getName2 = Employee::getName;
	
//	B. (Employee e,String s) -> e.setName(s)
	// type: Class::instanceMethod
	BiConsumer<Employee, String> setName1 = (e, s) -> e.setName(s);
	BiConsumer<Employee, String> setName2 = Employee::setName;
	
//	C. (String s1,String s2) -> s1.compareTo(s2)
	// type: Class::instanceMethod
	Comparator<String> compare1 = (s1,s2) -> s1.compareTo(s2);
	Comparator<String> compare2 = String::compareTo;
	
//	D. (Integer x,Integer y) -> Math.pow(x,y)
	// type: Class::staticMethod
	BiFunction<Integer, Integer, Double> pow1 = (x,y) -> Math.pow(x,y);
	BiFunction<Integer, Integer, Double> pow2 = Math::pow;	
	
	
//	E. (Apple a) -> a.getWeight()
	// type: Class::instanceMethod
	Function<Apple, Integer> getWeight1 = (a) -> a.getWeight();
	Function<Apple, Integer> getWeight2 = Apple::getWeight;
	
//	F. (String x) -> Integer.parseInt(x);
	// type: Class::staticMethod
	Function<String, Integer> parseInt1 = (x) -> Integer.parseInt(x);
	Function<String, Integer> parseInt2 = Integer::parseInt;
	
//	G. EmployeeNameComparator comp = new EmployeeNameComparator(); 
//	(Employee e1, Employee e2) -> comp.compare(e1,e2)
	// type: object::instanceMethod
	EmployeeNameComparator empComparator = new EmployeeNameComparator();
	Comparator<Employee> compareEmployee1 = (e1,e2) -> empComparator.compare(e1, e2);
	Comparator<Employee> compareEmployee2 = empComparator::compare;
	
	void evaluator(){
		//example
		System.out.println(toUpper2.apply("hello"));

		Employee e = new Employee("Mary");
		//A.		
		System.out.println("=======get name of employee=======");
		System.out.println(getName1.apply(e));
		//B.
		System.out.println("=======set name for employee=======");
		setName2.accept(e, "Susan");		
		System.out.println(getName1.apply(e));
		//C.
		System.out.println("=======compare 2 strings=======");		
		System.out.println(compare2.compare("abc", "abc"));
		//D.
		System.out.println("=======the result of the first number raised to the second number=======");
		System.out.println(pow2.apply(3,5));
		//E.
		System.out.println("=======get weight of an apple=======");
		Apple a = new Apple(20);
		System.out.println(getWeight2.apply(a));
		//F.
		System.out.println("=======convert a string to an integer=======");
		System.out.println(parseInt2.apply("34"));
		//G.
		System.out.println("=======compare two employees=======");
		Employee e2 = new Employee("Henry");
		Employee e3 = new Employee("Susan");
		System.out.println(compareEmployee2.compare(e, e2));
		System.out.println(compareEmployee2.compare(e, e3));
	}
	
	public static void main(String[] args){
		Prob6 p = new Prob6();
		p.evaluator();								
	}
}
