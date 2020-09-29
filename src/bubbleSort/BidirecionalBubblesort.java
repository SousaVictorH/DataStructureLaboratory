package bubbleSort;

import Utilidade.util;

public class BidirecionalBubblesort {

	public static void bidirecionalBubbleSort(int[] v, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < (rightIndex/2) + 1; i++) {
			
			for(int j=leftIndex; j<rightIndex; j++) {
				if(v[j] > v[j+1]) {
					util.swap(v, j, j+1);
				}
			}
			
			for(int j=rightIndex; j>leftIndex; j--) {
				if(v[j] < v[j-1]) {
					util.swap(v, j, j-1);
				}
			}
			
		}
		
		leftIndex++;
		rightIndex--;
		
	}
}
