package DataStructure;

public class NumberIdetifier {


	public static void main(String[] args) {
		NumberIdetifier numberIdetifier = new NumberIdetifier();
	/*	System.out.println("Is given number palindrome : " + numberIdetifier.isPalindrome(121));
		System.out.println("Is given number palindrome : " + numberIdetifier.isPalindrome(1212));
		System.out.println("Is given number palindrome : " + numberIdetifier.isPalindrome(49494));
		System.out.println("Is given number palindrome : " + numberIdetifier.isPalindrome(1331));

		numberIdetifier.getBinaryNumberFromDecimal(20);
		
		int[] numArray = {1,2,3,4,5 , 8};
		System.out.println("sum of even no : " + numberIdetifier.getSumOfEvenNumber(numArray));   */
		
		
	//	numberIdetifier.printTableOfGivenNumber(19);
		
		numberIdetifier.findFirstNonRepeatingChar("nyndini");

		
				
	}


	boolean isPalindrome(int GivenNumber){

		int originalNum = GivenNumber ;
		int remainder ;
		int reverseNum = 0;

		while(originalNum > 0){
			remainder = originalNum % 10;
			originalNum = originalNum /10 ;
			reverseNum = reverseNum * 10 + remainder ;

		}
		if(reverseNum == GivenNumber){
			return true ;
		}
		return false;

	}


	void getBinaryNumberFromDecimal(int number){
		int[] binary = new int[40];
		int index = 0 , remainder;
		while(number > 0){
			remainder = number % 2;
			binary[index++]= remainder;
			number = number /2 ;
		
		}
		
		for (int i = index-1; i >=0 ; i--) {
			System.out.print(binary[i]);
		}

	}
	
	int getSumOfEvenNumber(int[] numArray){
		int sum = 0;
		for(int i = 0 ; i< numArray.length ; i++){
			if(numArray[i]%2 == 0){
			sum  = sum + numArray[i];
			}
		}
		return sum;
		
	}
	
	void printTableOfGivenNumber(int number){
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println(number + " * "+ i + " = "+ number * i);
		}
	}

	
	void findFirstNonRepeatingChar(String str){
		int[] charCountArray = new int[256];
		for(int i = 0 ; i < str.length() ; i++){
			charCountArray[str.charAt(i)]++;
		}
		int index = -1 ; int second = 0 ;
		for( int i = 0 ; i < charCountArray.length ; i++){
				if(charCountArray[str.charAt(index)] == 1)	{
					index = 1;
				}		
		}
		System.out.println(str.charAt(index));
	}
}

