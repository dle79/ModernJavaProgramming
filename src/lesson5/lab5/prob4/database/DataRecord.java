package lesson5.lab5.prob4.database;

import java.time.LocalDate;

public class DataRecord {

	private String Id;
	private String name;
	private LocalDate birthOfDate;
	
	public DataRecord(String Id, String name, LocalDate birthOfDate)
	{
		this.Id = Id;
		this.name = name;
		this.birthOfDate = birthOfDate;
	}
	
	public String getId()
	{
		return Id;
	}
	public String getName()
	{
		return name;
	}
	public LocalDate getBirthOfDate()
	{
		return birthOfDate;
	}
}
