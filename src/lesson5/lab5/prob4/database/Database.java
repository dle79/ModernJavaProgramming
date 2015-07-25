package lesson5.lab5.prob4.database;

import java.time.LocalDate;
import java.util.HashMap;

public class Database {
	public static HashMap<String, DataRecord> hashData = new HashMap<String, DataRecord>();
	static {
		/*
		 * DataRecord format: Id, Name, Date
		 * */
		hashData.put("1", new DataRecord("1", "Deergahu", LocalDate.of(1988, 10, 2)) );
		hashData.put("2", new DataRecord("2", "Michael", LocalDate.of(1982, 3, 6) ) );
		hashData.put("3", new DataRecord("3", "Dung", LocalDate.of(1980, 5, 20)) );
		hashData.put("4", new DataRecord("4", "Khuong", LocalDate.of(1982, 3, 8)) );
	}
}
