package DataStructure;

public class Patterns {

	void printTrainglePattern(int level){

		int space = level -1  ;
		for(int i = 0 ; i < level ; i++){
			for(int k = 1 ; k <= space ; k++){
				System.out.print(" ");
			}
			space--;
			
			
			for(int j = 0 ; j <  (2*i + 1); j ++){
				System.out.print("*");
			}
			System.out.println();
		}
		space = 1; 
		for(int i = level-1 ; i> 0 ; i--){
			for(int k = 1 ; k <= space ; k++){
				System.out.print(" ");
			}
			space++;
			for(int j = 0 ; j <  (2*i - 1); j ++){
				System.out.print("*");
			}
			
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		Patterns patterns = new Patterns();
		patterns.printTrainglePattern(5);
	}
}
