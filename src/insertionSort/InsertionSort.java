package insertionSort;

import sorting.AbstractSorting;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		for(int i=leftIndex+1; i <= rightIndex; i++) {
			
			T x = array[i];
			int j = i - 1;
			
			while((j >= 0) && (array[j].compareTo(x) > 0)) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = x;
		}
		
	}
	
}