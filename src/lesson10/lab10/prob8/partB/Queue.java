package lesson10.lab10.prob8.partB;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class Queue {
	
	private int size = 0;
	private final int MAX_QUEUE_SIZE = 10;
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	public Queue()
	{
		head = tail = null;
	}
	
	/**
     * the method will add an object to this queue, and will notify any waiting
     * threads that there is an object available.
     */
	public synchronized void add(Object newValue) throws InterruptedException {
		
		while (isFull()) 
		{
	        wait();
	    }
		
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
		
		notifyAll();
	    size++;
	      
	}
	
	/*/**
     * Make a blocking remove job call so that it only returns when the queue has
     * something on it, otherwise we'll wait until something is put on it.
     * 
     * @returns  This will return null if the thread wait() call is interrupted.
     */
	
	public synchronized Object remove() throws InterruptedException {
		
		while (0 == size()) 
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	    }

		if(head == null) return null;
		Node n = head;
		head = n.next;
		size--;
		notifyAll();
		return n.value;
	}
	
	public synchronized int size() 
	{ 
		return size;
	}
	
	public boolean isFull() 
	{ 
		return MAX_QUEUE_SIZE == size();
	}
}
