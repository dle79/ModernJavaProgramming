package lesson3.lab3.prob2;

/**
 * Apartment
 */
public class Apartment {

    /**
     * Constructor
     */
    public Apartment(double rentalFee) {
    	if(rentalFee < 0)
    		throw new IllegalArgumentException("The rental fee is not real!");
    	this.rentalFee = rentalFee;
    }
    
    public double getRentalFee(){
    	return rentalFee;
    }

    /**
     * attributes
     */
    private double rentalFee;

}