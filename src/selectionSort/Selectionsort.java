package selectionSort;

import Utilidade.util;

public class Selectionsort {

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
