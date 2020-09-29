package insertionSort;

public class Recursiveinsertionsort {

	public static void recursiveInsertionSort(int[] v, int leftIndex, int rightIndex) {
		
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
