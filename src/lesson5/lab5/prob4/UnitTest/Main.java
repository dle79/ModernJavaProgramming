package lesson5.lab5.prob4.UnitTest;

import java.util.ArrayList;
import java.util.Collection;

import lesson5.lab5.prob4.database.DataRecord;
import lesson5.lab5.prob4.database.Database;
import lesson5.lab5.prob4.personbirthinfo.Person;
import lesson5.lab5.prob4.personbirthinfo.PersonBirthInfo;
import lesson5.lab5.prob4.personbirthinfo.PersonBirthInfoFactory;

public class Main {
	public static void main(String args[])
	{
		Collection<DataRecord> data = Database.hashData.values();
		ArrayList<Person> personList = new ArrayList<>();
		
		for(DataRecord item : data)
		{
			PersonBirthInfo pbi = PersonBirthInfoFactory.createPersonBirthIno(item.getName(), item.getBirthOfDate());
			personList.add(pbi.getPersonReport());
		}
		
		System.out.println("Person BirthDay Info:---------------\n");
		for(Person person : personList)
		{
			System.out.println(person.getName() + ":" + person.getBirthInfo().getDateOfBirth());
		}		
	}
}
