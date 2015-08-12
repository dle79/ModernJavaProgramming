package lesson10.lab10.prob8.partA;

// create multi thread environment 
public class Main 
{
	public static void main(String args[])
	{
		Queue queue = new Queue();
		final int THREADS = 10;
	    final int REPETITIONS = 50;
		for (int i = 1; i <= THREADS; ++i) {
			Producer pr = new Producer(queue, REPETITIONS);
			Consumer cr = new Consumer(queue, REPETITIONS);

			Thread dt = new Thread(pr);
			Thread wt = new Thread(cr);

			dt.start();
			wt.start();
		}
	}
}
