package quickSort;

import Utilidade.util;

public class Quicksort {

	public static void quickSort(int[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			int j = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, j-1);
			quickSort(array, j+1, rightIndex);
		}
		
	}

	private static int partition(int[] v, int leftIndex, int rightIndex) {
		
		int pivo = v[rightIndex];
		int i = leftIndex;
		
		for(int j=leftIndex; j<rightIndex; j++) {
			
			if(v[j] <= pivo) {
				util.swap(v, i, j);
				i++;
			}
			
		}
		
		util.swap(v, i, rightIndex);
		
		return i;
	}

}
