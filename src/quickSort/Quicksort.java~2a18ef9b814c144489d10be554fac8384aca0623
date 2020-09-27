package quickSort;
import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args) {
		
		int []v = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		quickSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));
		
	}

	private static void quickSort(int[] v, int esq, int dir) {
		
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
				trocar(v, i, j);
				i++;
			}
			
		}
		
		trocar(v, i, dir);
		
		return i;
	}

	private static void trocar(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}

}
