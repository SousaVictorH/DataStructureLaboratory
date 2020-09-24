package bubbleSort;

import java.util.Arrays;

public class recursivebubblesort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		recursiveBubbleSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	private static void recursiveBubbleSort(int[] v, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= v.length) {
			return;
		}
		
		for(int i=0; i<rightIndex; i++) {
			if(v[i] > v[i+1]) {
				troca(v, i, i+1);
			}
		}
		
		recursiveBubbleSort(v, leftIndex+1, rightIndex);
	}
	
	private static void troca(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}
	
}
