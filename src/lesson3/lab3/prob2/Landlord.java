package lesson3.lab3.prob2;
import java.util.*;

/**
 * Landlord
 */
public class Landlord {

    /**
     * constructor
     */
    public Landlord(String name) {
    	this.name = name;
    	this.buildings = new ArrayList<Building>();
    }
    
    public void addBuilding(Building building){
    	this.buildings.add(building);
    }
    
    public List<Building> getBuildings(){
    	return buildings;
    }
    
    public String getName(){
    	return name;
    }
    
    public double calculateMonthlyTotalProfit(){
    	double sum = 0.00;
    	for(Building b : buildings){
    		sum = sum + (b.getTotalRentalFee() - b.getMaintainanceCost());
    	}
    	return sum;
    }
    /**
     * attributes
     */
    private String name;
    private List<Building> buildings;


}