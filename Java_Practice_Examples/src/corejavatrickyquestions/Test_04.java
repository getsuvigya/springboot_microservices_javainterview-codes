package corejavatrickyquestions;

import java.util.HashMap;
import java.util.Map;

class Solution {
	
	int max;
	int min;
	void findSmallestAndBiigest(int A[]){
		
		for(int i=1; i<A.length; i++){
			if(A[i]>max){
				max=A[i];
			}
			if(A[i]<min){
				min = A[i];
			}
		}
	}
    public int solution(int[] A) {
        // write your code in Java SE 8
    	max=min=A[0];
    	
    	Map<Integer, Integer> map =new HashMap<>();
    	for(int i=0; i<A.length; i++){
    		if(A[i]>max){
				max=A[i];
			}
			if(A[i]<min){
				min = A[i];
			}
    		if(map.containsKey(A[i])){
    			int k = map.get(A[i]);
    			k++;
    			map.put(A[i], k);
    		}else{
    			map.put(A[i], 1);
    		}
    		
    	}
    	int smallest = 0;
    	 for(int k=min+1;k<max;k++){
    	    	if(!map.containsKey(k) && k>0){
    	    		return k;
    	    	}
    	    }
    	 if(min<=0 && max<=0){
    		 return 1;
    	 }else if(min-0>1){
    		 return 1;
    	 }else{
    		 return max+1;
    	 }
    }
    
   
}
