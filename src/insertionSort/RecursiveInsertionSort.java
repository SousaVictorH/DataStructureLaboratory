package insertionSort;

import sorting.AbstractSorting;

public class RecursiveInsertionSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		T x = array[leftIndex + 1];
		int pos = leftIndex;
		
		while((pos >= 0) && (array[pos].compareTo(x) > 0)) {
			array[pos+1] = array[pos];
			pos--;
		}
		
		array[pos+1] = x;
		
		sort(array, leftIndex+1, rightIndex);
		
}

}
