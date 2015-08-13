package lesson11.lab11.prob5;


public class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "(name:"+name + ", " + age + ")";
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age - o.getAge();
	}
}
