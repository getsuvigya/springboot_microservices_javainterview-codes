package nandini;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
@RunWith(Parameterized.class)
public class PrimeNumberTestClass {
	int number ;
	boolean expectedResult;
	PrimeNumberClass class1;
	
	public PrimeNumberTestClass(int number, boolean expectedResult) {
		this.number = number;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void initailze(){
		class1 = new PrimeNumberClass();
	}
	@Parameters
	public static Collection getParameter(){
		return Arrays.asList(new Object[][]{
			{ 2, true },
			{ 3, true },
			{ 27 , true },
			{ 33 , true },
			{ 143 , false },
			{ 31 , true }
		});
	}

	@Test
	public void checkPrimeNumberTest(){
		//System.out.println("Number is ->" + number);
		assertEquals(expectedResult, class1.checkPrimeNumber(number) );
	}


}
