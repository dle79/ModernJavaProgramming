package lesson2.prob2a;
import java.util.*;

/**
 * Student
 */
public class Student {

    /**
     *Contructor
     */
	
    public Student(String name, String grade) {
    	this.name = name;
    	this.grade = new GradeReport(this, grade);
    }
    
    
    public Student(String name, GradeReport grade) {
    	this.name = name;    
    	this.grade = grade;
    }

     
    /**
     * Attributes
     */
    private String name;
    private GradeReport grade;

}