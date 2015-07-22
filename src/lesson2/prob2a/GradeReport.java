package lesson2.prob2a;
import java.util.*;

/**
 * GradeReport 
 */
public class GradeReport {

    /**
     * Constructor 
     */
    public GradeReport(Student student, String grade) {
    	this.student = student;
    	this.grade = grade;
    }
    
    public GradeReport(String name, String grade) {    	
    	this.grade = grade;
    	this.student = new Student(name, this);
    }
         
    private Student student;
    private String grade;
}