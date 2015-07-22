package lesson2.lab2;

import java.util.*;

/**
 * 
 */
public class Project {

    /**
     * relationship between Project and Release: 1 : 1..* (directed)
     * relationship between Project and Feature: 1 : 1..* (directed)
     */
    public Project(String projectID, List<Release> releases, List<Feature> features) {
    	this.projectID = projectID;
    	this.releaseList = releases;
    	this.backlogFeatureList = features;
    }

    /**
     * 
     */
    private String projectID;

    /**
     * 
     */
    private List<Feature> backlogFeatureList;

    /**
     * 
     */
    private List<Release> releaseList;



}