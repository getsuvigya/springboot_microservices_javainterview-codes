package JavaProgram;

import java.util.Scanner;

public class Fabonacci {

	private int getFabonaciByRecursion(int range){

		if(range == 1 || range == 2 )
			return 1;
         
		return getFabonaciByRecursion(range - 1) + getFabonaciByRecursion(range - 2);

	}
	
	
   private int getFabonacciByLoop(int range){
	   if(range == 1 || range == 2 )
			return 1;
	   
	   int f1 = 1 , f2 = 1 , f3 = 1;
	   for(int i = 3 ; i <= range; i++)
	   {
		   f3 = f1 + f2 ;
		   f1 = f2 ;
		   f2 = f3;
		   
	   }
	  return f3;
	   
   }

	public static void main(String[] args) {
		System.out.println("Range-->\t");
		int range = new Scanner(System.in).nextInt();
		Fabonacci f = new Fabonacci();
		for(int i = 1 ; i <= range ; i++){
			System.out.print(f.getFabonaciByRecursion(i)+"\t");
		}
		
		System.out.println();
		for(int i = 1 ; i <= range ; i++){
			System.out.print(f.getFabonacciByLoop(i)+"\t");
		}
		
	
	}
}

