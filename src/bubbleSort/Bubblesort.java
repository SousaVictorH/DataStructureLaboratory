package bubbleSort;

import java.util.Arrays;

public class Bubblesort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		bubbleSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	private static void bubbleSort(int[] v, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			for(int j = rightIndex; j > i ; j--) {
				
				if(v[j] < v[j-1]) {
					
					troca(v, j, j-1);
					
				}
				
			}
			
		}
		
	}

	private static void troca(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}
	
	
}
