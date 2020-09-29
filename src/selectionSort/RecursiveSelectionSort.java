package selectionSort;

import Utilidade.util;

public class RecursiveSelectionSort {

	public static void recursiveSelectionSort(int[] v, int leftIndex, int rightIndex) {
		
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
			util.swap(v, leftIndex, posMin);
		}
		
		recursiveSelectionSort(v, leftIndex+1, rightIndex);
		
	}

}
