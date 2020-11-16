package sortsRecursivos;

import util.Util;
import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		for(int i=0; i<rightIndex; i++) {
			if(array[i].compareTo(array[i+1]) > 0) {
				Util.swap(array, i, i+1);
			}
		}
		
		sort(array, leftIndex+1, rightIndex);
	}

}