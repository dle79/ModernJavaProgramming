package lesson2.lab2;

import java.util.*;

/**
 * 
 */
public class Sprint {

    /**
     * 
     */
    public Sprint(List<Feature> sprintFeatures, Date dueDate , Developer developer) {
    	this.sprintFeatures = sprintFeatures;
    	this.dueDate = dueDate;
    	this.developer = developer;
    }

    /**
     * 
     */
    private List<Feature> sprintFeatures;

    /**
     * 
     */
    private Date dueDate;

    /**
     * 
     */
    private Developer developer;


}