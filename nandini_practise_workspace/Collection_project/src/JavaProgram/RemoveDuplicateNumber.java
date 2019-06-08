package JavaProgram;

import java.util.Arrays;

public class RemoveDuplicateNumber {

	public static void main(String[] args) {
		int[] a = new int[]{2,4,2,6,1,9,2,1,9};
		Arrays.sort(a); 
		
		for(int i : a){
			System.out.print(i+"\t");
		}
	
		int[] result = new int[a.length];
		int prev = a[0];
		result[0] = a[0];
		for(int i1 = 1 ; i1 < result.length ; i1++)
		{
			int ch = a[i1];
			if(ch != prev){
				result[i1] = a[i1];
			}
			prev = ch ;
		}
		System.out.println();
		
		for(int i : result){
			System.out.print(i+"\t");
		}
	}
	
	
}
