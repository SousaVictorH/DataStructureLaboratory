package sortsPadroes;

import util.Util;
import sorting.AbstractSorting;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			for(int j = rightIndex; j > i ; j--) {
				
				if(array[j].compareTo(array[j-1]) < 0) {
					
					Util.swap(array, j, j-1);
					
				}
				
			}
			
		}
		
	}
}