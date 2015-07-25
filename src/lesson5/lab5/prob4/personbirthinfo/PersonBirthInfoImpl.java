package lesson5.lab5.prob4.personbirthinfo;

//Immutable relative to its package personbirthinfo
final class PersonBirthInfoImpl implements PersonBirthInfo {
	
	private Person person;
	private BirthInfo birthInfo;
	
	public PersonBirthInfoImpl(Person person, BirthInfo birthInfo)
	{
		this.person = person;
		this.birthInfo = birthInfo;
	}
	
	@Override
	public Person getPersonReport()
	{
		return person;
	}

	@Override
	public BirthInfo getBirthInfoReport()
	{
		return birthInfo;
	}
}
