package bubbleSort;

import Utilidade.util;

public class Bubblesort {

	public static void bubbleSort(int[] v, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			for(int j = rightIndex; j > i ; j--) {
				
				if(v[j] < v[j-1]) {
					
					util.swap(v, j, j-1);
					
				}
				
			}
			
		}
		
	}
	
}
