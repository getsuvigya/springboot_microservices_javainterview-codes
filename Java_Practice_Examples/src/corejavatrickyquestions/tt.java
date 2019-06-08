package corejavatrickyquestions;

public class tt {
	public int solution(int[] A) {
        // write your code in Java SE 8
		if(A[0]<A[A.length-1]){
			return 1;
		}
    }
	
	public int returnPivot(int [] A){ 
		
		int n = A.length;
		int pivot = A[n-1];
		for(int i=n-1;i>=0;i--){
			if(pivot<A[i]){
				pivot = i;
			}
		}
		return pivot;
	}
	 
	int sort(int A[], int l,int pivot,int r){
		int m = pivot
	}
}
