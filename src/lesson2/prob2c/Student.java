package lesson2.prob2c;

import java.util.*;

/**
 * Student
 */
public class Student {

	/**
	 * Constructor
	 */
	public Student(String name) {
		this.name = name;
		sections = new HashSet<Section>();
	}

	public void addSection(Section section) {
		sections.add(section);
		if (!section.getStudents().contains(this)) {
			section.addStudent(this); 
		}
	}
	
	public Set<Section> getSections(){
		return sections;
	}

	/**
	 * attributes
	 */
	public String name;
	private Set<Section> sections;

	public String toString() {
		return this.name;
	}

}