package bubbleSort;

import java.util.Arrays;

import Utilidade.util;

public class BidirecionalBubblesort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		bidirecionalBubbleSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

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
