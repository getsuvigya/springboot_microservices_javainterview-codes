 package DataStructure;

class MergeSort 
{ 
	public static void main(String[] args) {
		int[] array = {34 , 0 , 2 , 1 , 7 , 9 , 37 , 9 , 91};
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array , 0 , array.length - 1);
		mergeSort.printSortedArray(array);
	}

	private void sort(int[] array, int l, int r) {
		if(l < r){
			int m = (l+r) / 2 ;

			sort(array , l , m);
			sort(array , m+1 , r);

			merge(array , l , m , r);	
		
		}

	}
	
	
	void printSortedArray(int[] array){
		for(int i : array){
			System.out.print(i+ " , ");
		}
	}

	private void merge(int[] array, int l, int m, int r) {

		int n1 = m - l + 1 ;
		int n2 = r - m ;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for(int i = 0 ; i < n1 ; i++){
			L[i] = array[l+i];
		}

		for(int i = 0 ; i < n2 ; i++){
			R[i] = array[m+1+i];
		}

		int i = 0 , j= 0;
		int k = l;
		while(i < n1 && j < n2){
			
			if(L[i] <= R[j]){
				array[k] = L[i];
				i++;
			}else{
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		
		while(i<n1){
			array[k] = L[i];
			i++;
			k++;
		}
		
		while(j<n2){
			array[k] = R[j];
			j++;
			k++;
		}
	
	}
} 

