package selectionSort;

import java.util.Arrays;

public class Selectionsort {
	
	public static void main(String[] args) {
		
		int []v = {1, 2, 4, 3, 7, 5, 6};
		
		selectionSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
	}

	private static void selectionSort(int[] v, int inicio, int fim) {
		
		for(int j=inicio; j<=fim; j++) {
			
			int posMin = j;
			
			for(int i=j; i<=fim; i++) {
				
				if(v[i] < v[posMin]) {
					posMin = i;
				}
				
			}
			
			if(v[j] > v[posMin]) {
				troca(v, j, posMin);
			}
			
		}
			
	}
	
	private static void troca(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}
	
}
