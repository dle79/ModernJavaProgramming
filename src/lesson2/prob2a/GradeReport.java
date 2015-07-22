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
    
    public GradeReport(String grade) {    	
    	this.grade = grade;
    }
    
    public Student getStudent(){
    	return student;
    }
    
    public void setStudent(Student student){
    	this.student = student;
    }
    
    public String getGrade(){
    	return grade;
    }
    
    public void setGrade(String grade){
    	this.grade = grade;
    }
    
    private Student student;
    private String grade;
}