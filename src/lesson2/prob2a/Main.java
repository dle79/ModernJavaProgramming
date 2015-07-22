package lesson2.prob2a;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student("Bob", new GradeReport("A"));
		GradeReport gradeStudent1 = student1.getGradeReport();
		gradeStudent1.setStudent(student1);
		
		GradeReport gradeStudent2 = new GradeReport(new Student("Helen"), "A+");
		Student student2 = gradeStudent2.getStudent();
		student2.setGradeReport(gradeStudent2);
		
	}

}
