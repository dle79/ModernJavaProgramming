package lesson5.lab5.prob4.personbirthinfo;

import java.time.LocalDate;

//Outsisde of personbirthinfo package, BirthInfo is immutable
//Immutability in this case depends on the factory that Person is immutable
public class BirthInfo {
	
	private LocalDate dateOfBirth;
	private Person person;
	
	// package level access
	BirthInfo(LocalDate dob) {
		dateOfBirth = dob;
	}
	
	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	// package level access
	void setPerson(Person person)
	{
		this.person = person;
	}
	
	public Person getPerson()
	{
		return person;
	}
}
