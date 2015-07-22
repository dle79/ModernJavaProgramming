package lesson2.lab2;

import java.util.*;

/**
 * 
 */
public class Release {

    /**
     * Relationship between Release and Sprint : 1 : 1..* (directed)
     */
    public Release(List<Sprint> sprints) {
    	this.sprintList = sprints;
    }

    /**
     * 
     */
    private List<Sprint> sprintList;


}