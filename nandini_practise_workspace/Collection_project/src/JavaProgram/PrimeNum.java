package JavaProgram;

public class PrimeNum {

	public static void main(String[] args) {

		PrimeNum primeCheck = new PrimeNum();
		System.out.println("3_-> "    +    primeCheck.isPrimeBySqrt(3));
		System.out.println("30_-> "   +    primeCheck.isPrimeBySqrt(30));
		System.out.println("31_-> "   +    primeCheck.isPrimeBySqrt(31));
		System.out.println("231_-> "  +    primeCheck.isPrimeBySqrt(231));
		System.out.println("1024_-> " +    primeCheck.isPrimeBySqrt(1024));
		System.out.println("1001_-> " +    primeCheck.isPrimeBySqrt(1001));


	
		
		
		System.out.println("3_-> "    +    primeCheck.isPrime(3));
		System.out.println("30_-> "   +    primeCheck.isPrime(30));
		System.out.println("31_-> "   +    primeCheck.isPrime(31));
		System.out.println("231_-> "  +    primeCheck.isPrime(231));
		System.out.println("1024_-> " +    primeCheck.isPrime(1024));
		System.out.println("1001_-> " +    primeCheck.isPrime(1001));
        
	}

	private boolean isPrimeBySqrt(int num){
		int sqrt = (int )Math.sqrt(num);
		for(int i = 2 ; i <= sqrt ; i++){
			if(num % i == 0)
				return false;
		}
		return true;

	}

	private boolean isPrime(int num){
		if( num == 2 || num == 3)
			return true;

		if(num % 2 == 0)
			return false;

		int sqrt = (int)Math.sqrt(num);
		for(int i = 3 ; i <= sqrt ; i += 2){
			if( num % i == 0 ){
				return false;
			}
		}

		return true;

	}
}
