package DataStructure;

public class SetOperations {

	
	void printUnion(int[] arr1 , int[] arr2){
		
		int[] union = new int[arr1.length+arr2.length];
		for(int i = 0 ; i < arr1.length ; i++){
			union[i] = arr1[i];
		}
		int pointer = arr1.length ;
		for(int j = 0 ; j < arr2.length ; j++){
		
			
			boolean isAlreadyIn = false ;
			for(int k = 0 ; k < arr1.length ; k++){
				if(arr2[j]==arr1[k]){
					isAlreadyIn = true ;
				}
			}
			if(!isAlreadyIn){
				union[pointer++] = arr2[j];
			}
		}
		
		for(int s = 0 ;  s < pointer ; s++ ){
			System.out.print(union[s]+" ");
		}
	}
		
	
	void printIntersection(int[] arr1 , int[] arr2){
		int[] intersection = new int[arr1.length+arr2.length];
		int pointer = 0;
		for(int i = 0 ; i < arr1.length ; i++){
			
			boolean isCommon = false ;
			for(int k = 0 ; k < arr2.length ; k++){
				if(arr1[i]==arr2[k]){
					isCommon = true ;
				}
			}
			if(isCommon){
				intersection[pointer++] = arr1[i];
			}
			
		}
		for(int s = 0 ;  s < pointer ; s++ ){
			System.out.print(intersection[s]+" ");
		}
	}
	
	
	
	void printDifference(int[] arr1 , int[] arr2){
		
	}
	

	public static void main(String[] args) {
		SetOperations operations = new SetOperations();
		int[] arr1 = {6, 5,2,9 , 3 , 7};
		int[] arr2 = {5,1 , 9 , 2 ,10};
		operations.printUnion( arr1 , arr2);
		System.out.println();
		operations.printIntersection(arr1, arr2);
	}
	
	 
}
