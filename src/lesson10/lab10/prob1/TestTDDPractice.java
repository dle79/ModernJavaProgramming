package lesson10.lab10.prob1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTDDPractice {

	@Test
	public void test() {
				
		List<String> arr1 = new ArrayList<String>();
		arr1.add("abc");
		arr1.add("mnb");
		arr1.add("oiu");
		arr1.add("ppt");
		List<String> arr3 = new ArrayList<String>();
		arr3.add("abC");
		arr3.add("mnB");
		arr3.add("oiU");
		arr3.add("ppT");
		
		arr1 = TDDPractice.changeLastCharToUpper(arr1);

		assertEquals(arr3.size(), arr1.size());
		
		for(int i= 0; i<arr3.size() ; i++){
			assertEquals(arr3.get(i), arr1.get(i));
		}
		
		
	}

}
