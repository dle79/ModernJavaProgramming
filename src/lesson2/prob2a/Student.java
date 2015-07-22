package lesson2.prob2a;
import java.util.*;

/**
 * Student
 */
public class Student {

    /**
     *Contructor
     */
	
    public Student(String name, GradeReport grade) {
    	this.name = name;
    	this.grade = grade;
    }
    
    public Student(String name) {
    	this.name = name;    
    }

    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public GradeReport getGradeReport(){
    	return grade;
    }
    
    public void setGradeReport(GradeReport grade){
    	this.grade = grade;
    }
    
    /**
     * Attributes
     */
    private String name;
    private GradeReport grade;

}