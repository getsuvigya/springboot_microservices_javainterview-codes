package nandini;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class PrimeNumberClass{
		

	public boolean checkPrimeNumber(int number){
		for(int i = 2 ;i < number/2 ; i++){
			if(number % i == 0){
				return false;
			}
		}
	 return true ;
	}
	
}




