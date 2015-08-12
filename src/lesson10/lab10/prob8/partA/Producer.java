package lesson10.lab10.prob8.partA;

// add worker to queue
public class Producer implements Runnable 
{
	private static final int DELAY = 1000;
	private Queue queue;
	private int count;

	public Producer(Queue queue, int count) 
	{
		this.queue = queue;
		this.count = count;
	}

	public void run() 
	{
		try 
		{
			for (int i = 0; i < count; ++i) 
			{
				System.out.println("Adding " + i);
				queue.add(i);
				Thread.sleep(DELAY);
			}
		} 
		catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}