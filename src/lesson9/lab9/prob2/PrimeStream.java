package lesson9.lab9.prob2;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimeStream {
	

	void printFirstNPrimes(long n){
		Stream.iterate(BigInteger.valueOf(2), number -> number.nextProbablePrime()).limit(n).forEach(i -> System.out.println(i));
	}
	
	
}
