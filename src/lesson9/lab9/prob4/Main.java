package lesson9.lab9.prob4;

import java.util.stream.IntStream;

public class Main {

	public static void main(String args[])
	{
		printSquares(4);
	}
	public static void printSquares(int num)
	{
		IntStream.iterate(1, i -> i+1).limit(num).map(n -> n*n).forEach(System.out::println);
	}
}
