package lesson5.lab5.prob4.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import lesson5.lab5.prob4.database.DataRecord;
import lesson5.lab5.prob4.database.Database;
import lesson5.lab5.prob4.personbirthinfo.Person;
import lesson5.lab5.prob4.personbirthinfo.PersonBirthInfo;
import lesson5.lab5.prob4.personbirthinfo.PersonBirthInfoFactory;



public class UnitTest {

	@org.junit.Test
	public void test() {
		Collection<DataRecord> data = Database.hashData.values();
		ArrayList<Person> personList = new ArrayList<>();
		
		for(DataRecord item : data)
		{
			PersonBirthInfo pbi = PersonBirthInfoFactory.createPersonBirthIno(item.getName(), item.getBirthOfDate());
			personList.add(pbi.getPersonReport());
		}
		
		Iterator<DataRecord> itr1 = data.iterator(); 
		Iterator<Person> itr2 = personList.iterator();
		DataRecord dataRecordNext = null;
		Person personNext = null;
		while(itr1.hasNext() && itr2.hasNext())
		{
			dataRecordNext = itr1.next();
			personNext = itr2.next();
			
			assertTrue(dataRecordNext.getName().equals(personNext.getName()) );
			assertTrue(dataRecordNext.getBirthOfDate().equals(personNext.getBirthInfo().getDateOfBirth()) );
			
		}
	}

}
