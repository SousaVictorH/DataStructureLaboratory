package insertionSort;

public class Insertionsort {

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
