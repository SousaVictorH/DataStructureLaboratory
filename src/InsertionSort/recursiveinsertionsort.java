package InsertionSort;

import java.util.Arrays;

public class recursiveinsertionsort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		recursiveInsertionSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	private static void recursiveInsertionSort(int[] v, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= v.length) {
			return;
		}
		
		int x = v[leftIndex + 1];
		int pos = leftIndex;
		
		while((pos >= 0) && (v[pos] > x)) {
			v[pos+1] = v[pos];
			pos--;
		}
		
		v[pos+1] = x;
		
		recursiveInsertionSort(v, leftIndex+1, rightIndex);
		
	}
	
}
