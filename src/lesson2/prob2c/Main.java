package lesson2.prob2c;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Bob");
		Section section1 = new Section(1,"Helen");
		Section section2 = new Section(2,student1);
		
		section1.addStudent(student1);
		
		for(Student s : section1.getStudents()){
			System.out.println("Student " + s.name);			
			for(Section sec : s.getSections()){
				System.out.println("Section " + sec.sectionNum);
				System.out.println(sec.getStudents());
			}
			System.out.println("================");
		}				
	}

}
