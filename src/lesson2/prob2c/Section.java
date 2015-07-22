package lesson2.prob2c;

import java.util.*;

/**
 * Section
 */
public class Section {

	/**
	 * Constructors
	 */
	public Section(int sectionNum, String studentName) {
		this.sectionNum = sectionNum;
		this.students = new HashSet<Student>();
		Student student = new Student(studentName);
		this.students.add(student);
		student.addSection(this);
	}

	public Section(int sectionNum, Student student) {
		this.sectionNum = sectionNum;
		this.students = new HashSet<Student>();
		this.students.add(student);
		if (!student.getSections().contains(this)) {
			student.addSection(this);
		}
	}

	public void addStudent(Student student) {
		this.students.add(student);
		student.addSection(this);
	}
	
	public Set<Student> getStudents(){
		return students;
	}

	/**
	 * Attributes
	 */
	public int sectionNum;
	private Set<Student> students;

	public String toString() {
		return String.valueOf(this.sectionNum);
	}
}