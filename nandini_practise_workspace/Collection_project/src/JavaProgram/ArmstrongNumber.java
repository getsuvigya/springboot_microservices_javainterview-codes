package JavaProgram;

public class ArmstrongNumber {

	public static void main(String[] args) {
		ArmstrongNumber armstrongNumber = new ArmstrongNumber();
		armstrongNumber.isNumberArmStrong(15);
	}
	
	private void isNumberArmStrong(int number){
		
		int temp = number , digit = 0 , remainder = 0 , sum = 0;
		
		while(temp != 0){
			digit++;
	        temp = temp/10;
		}
		temp = number;
		while(temp != 0){
			remainder = temp %10;
			sum = sum + power(remainder , digit);
			temp = temp/10;
		}
		
		if(sum == number){
			System.out.println("Arm strong");
			return;
		}
		
		System.out.println("Arm strong Not");
	}
	
	
	private int power(int num , int powerDigit){
		int sum = 1;
		for(int i = 1; i<= powerDigit ; i++)
		{
			sum = sum*num ;
		}
		
		return sum;
	}
	
}
