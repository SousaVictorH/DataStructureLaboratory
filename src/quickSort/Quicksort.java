package quickSort;
import java.util.Arrays;

import Utilidade.util;

public class Quicksort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		
		//int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		//int []v = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};

		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0};
		//int []v = {1, 5, 7, 9, 7, 5, 4, 2, 0, -5};
		
		quickSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
		
	}

	public static void quickSort(int[] v, int esq, int dir) {
		
		if(esq < dir) {
			int j = separar(v, esq, dir);
			quickSort(v, esq, j-1);
			quickSort(v, j+1, dir);
		}
		
	}

	private static int separar(int[] v, int esq, int dir) {
		
		int pivo = v[dir];
		int i = esq;
		
		for(int j=esq; j<dir; j++) {
			
			if(v[i] <= pivo) {
				util.swap(v, i, j);
				i++;
			}
			
		}
		
		util.swap(v, i, dir);
		
		return i;
	}

}
