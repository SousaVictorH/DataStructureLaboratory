package selectionSort;

import java.util.Arrays;

public class RecursiveSelectionSort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		recursiveSelectionSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));

	}

	private static void recursiveSelectionSort(int[] v, int leftIndex, int rightIndex) {
		
		if(leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex > v.length || leftIndex == rightIndex) {
			return;
		}
		
		int posMin = leftIndex;
		
		for(int i=leftIndex; i<=rightIndex; i++) {
			
			if(v[i] < v[posMin]) {
				posMin = i;
			}
			
		}
		
		if(v[leftIndex] > v[posMin]) {
			troca(v, leftIndex, posMin);
		}
		
		recursiveSelectionSort(v, leftIndex+1, rightIndex);
		
	}
	
	private static void troca(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}

}
