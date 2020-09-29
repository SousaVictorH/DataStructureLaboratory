package bubbleSort;

import Utilidade.util;

public class Recursivebubblesort {

	public static void recursiveBubbleSort(int[] v, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= v.length) {
			return;
		}
		
		for(int i=0; i<rightIndex; i++) {
			if(v[i] > v[i+1]) {
				util.swap(v, i, i+1);
			}
		}
		
		recursiveBubbleSort(v, leftIndex+1, rightIndex);
	}
	
}
