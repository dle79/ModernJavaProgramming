package lesson5.lab5.prob4.personbirthinfo;

//Outsisde of personbirthinfo package, Person is immutable
//Immutability in this case depends on the factory that BirthInfo is immutable
final public class Person {
	
	private String name;
	private BirthInfo birthInfo;
	
	// package level access
	Person(String name) {
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	// package level access
	void setBirthInfo(BirthInfo birthInfo)
	{
		this.birthInfo = birthInfo;
	}
	
	public BirthInfo getBirthInfo()
	{
		return birthInfo;
	}
}
