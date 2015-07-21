package lesson2.prob2b;

import java.util.*;

/**
 * 
 */
public class Order {

    /**
     * Constructor 
     */
    public Order(int orderNum, List<OrderLine> orderLines) {
    	this.orderNum = orderNum;
    	this.orderLines = orderLines;
    }
    
    public int getOrderNum(){
    	return orderNum;
    }

    public List<OrderLine> getOrderLines(){
    	return orderLines;
    }
    
    public void setOrderNum(int orderNum){
    	this.orderNum = orderNum;    	
    }
    
    public void setOrderLines(List<OrderLine> orderLines){
    	this.orderLines = orderLines;
    }
    /**
     * 
     */
    private int orderNum;
    private List<OrderLine> orderLines;

}