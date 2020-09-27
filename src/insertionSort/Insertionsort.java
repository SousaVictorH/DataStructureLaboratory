package insertionSort;

import java.util.Arrays;

public class Insertionsort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		insertionSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	public static void insertionSort(int[] v, int leftIndex, int rightIndex) {
		
		int x,j;
		
		for(int i=leftIndex+1; i <= rightIndex; i++) {
			
			x = v[i];
			j = i - 1;
			
			while((j >= 0) && (v[j] > x)) {
				v[j+1] = v[j];
				j--;
			}
			
			v[j+1] = x;
		}
		
	}

}
