package lesson2.lab2;


import java.util.*;

/**
 * 
 */
public class Developer {

    /**
     * Relationship bw Developer & Feature: 1: 0..* (directed)
     * Relationship bw Developer & Sprint: 1: 1 (association)
     */
    public Developer(String developerId, List<Feature> assignmentFeatures, List<Sprint> sprints) {
    	this.developerId = developerId;
    	this.assignmentFeatures = assignmentFeatures;
    	this.sprints = this.sprints;
    }

    /**
     * Relationship bw Developer & Feature: 1: 0..* (directed)
     */
    public Developer(String developerId, List<Sprint> sprints) {
    	this.developerId = developerId;
    	this.sprints = this.sprints;
    }

    /**
     * 
     */
    private List<Feature> assignmentFeatures;

    /**
     * 
     */
    private String developerId;


    /**
     * 
     */
    private Sprint sprints;
}