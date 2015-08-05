package lesson8.lab8.prob2.partB;


public class Employee {
	String name;
	int salary;
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(name);
		sb.append(" salary: ");
		sb.append("" + salary+">");
		return sb.toString();
		
	}
	@Override
	public boolean equals(Object ob) {
		
		if(ob == null) return false;
		
		if(this == ob) return true;
		
		if(ob.getClass() != this.getClass()) return false;
		
		Employee e = (Employee)ob;
		
		if(e.name.equals(name))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}
}

