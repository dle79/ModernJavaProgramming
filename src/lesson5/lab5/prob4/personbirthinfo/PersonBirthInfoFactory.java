package lesson5.lab5.prob4.personbirthinfo;

import java.time.LocalDate;

/** Typical use: Loading data from database into class model */
final public class PersonBirthInfoFactory {

	public static PersonBirthInfo createPersonBirthIno(String name, LocalDate dateOfBirth)
	{
		Person p = new Person(name);
		BirthInfo b = new BirthInfo(dateOfBirth);
		
		p.setBirthInfo(b);
		b.setPerson(p);
		
		return new PersonBirthInfoImpl(p,b);
	}
}
