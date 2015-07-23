package lesson3.lab3.prob2;
import java.util.ArrayList;
import java.util.List;

/**
 * Building
 */
public class Building {

    /**
     * Constructor
     */
    public Building(double maintainanceCost) {
    	if(maintainanceCost < 0){
    		throw new IllegalArgumentException("The maintainance cost is not real!");
    	}
    	this.maintainanceCost = maintainanceCost;
    	this.apartments = new ArrayList<Apartment>();
    }
    
    public void addApartment(Apartment apartment){
    	this.apartments.add(apartment);
    }
    
    public List<Apartment> getApartments(){
    	return apartments;
    }
    
    public double getMaintainanceCost(){
    	return maintainanceCost;
    }
    
    public double getTotalRentalFee(){
    	double sum = 0.00;
    	for(Apartment a : apartments){
    		sum = sum + a.getRentalFee();
    	}
    	return sum;
    }

    /**
     * attributes
     */
    private double maintainanceCost;
    private List<Apartment> apartments;


}