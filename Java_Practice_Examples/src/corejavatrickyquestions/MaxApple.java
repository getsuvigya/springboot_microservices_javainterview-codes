package corejavatrickyquestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MaxApple {
	 public int solution(int[] A, int K, int L) {
	        // write your code in Java SE 8
		 int sumAlice=0;
		 int sumBob = 0;
		 int n= A.length;
		 Map<Integer,Integer> mapAlice = new LinkedHashMap<>();
		 Map<Integer,Integer> mapBob = new LinkedHashMap<>();
		 int i=0;
		 int j=i+K+1;
		 for(i=0;i<n-K;i++){
			 sumAlice = 0;
			 for(int x=i;x<K+i;x++){
				 
				 sumAlice = sumAlice+A[x];
			 }
			 mapAlice.put(i, sumAlice);
		 }
		 if(j>n){
			 return -1;
		 }
		 for(;j<n-L;j++){
			 sumBob = 0;
			 for(int x=j;x<j+L;x++){
				 
				 sumBob = sumBob+A[x];
			 }
			 mapBob.put(j, sumBob);
		 }
		 
		 int diff = i-L;
		 if(diff>=0){
			 for(int t=0; t< i-L; t++){
				 sumBob = 0;
				 for(int x=t;x<t+L;x++){
					 
					 sumBob = sumBob+A[x];
				 }
				 mapBob.put(t, sumBob);
			 }
		 }
		 int max1 = 0;
		 for(int z=0;z<n;z++){
			 
			 int actualSum = 0;
			 
			 for(int u=z+K+1; u<n-L; u++){
				 if((mapAlice.containsKey(z) && mapBob.containsKey(u)) && (mapAlice.get(z)+mapBob.get(u))>actualSum){
					 actualSum = mapAlice.get(z)+mapBob.get(u);
				 }
			 }
			 if(max1<actualSum){
				 max1= actualSum;
			 }
		 }
	 }
}
