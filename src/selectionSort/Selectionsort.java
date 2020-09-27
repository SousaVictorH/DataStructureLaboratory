package selectionSort;

import java.util.Arrays;

import Utilidade.util;

public class Selectionsort {
	
	public static void main(String[] args) {
		
		int []v = {1, 2, 4, 3, 7, 5, 6};
		
		selectionSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	public static void selectionSort(int[] v, int inicio, int fim) {
		
		for(int j=inicio; j<=fim; j++) {
			
			int posMin = j;
			
			for(int i=j; i<=fim; i++) {
				
				if(v[i] < v[posMin]) {
					posMin = i;
				}
				
			}
			
			if(v[j] > v[posMin]) {
				util.swap(v, j, posMin);
			}
			
		}
			
	}
	
}
