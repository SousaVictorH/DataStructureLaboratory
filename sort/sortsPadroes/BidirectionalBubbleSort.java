package sortsPadroes;

import util.Util;
import sorting.AbstractSorting;

public class BidirectionalBubbleSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		for(int i = leftIndex; i < (rightIndex/2) + 1; i++) {
			
			for(int j=leftIndex; j<rightIndex; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					Util.swap(array, j, j+1);
				}
			}
			
			for(int j=rightIndex; j>leftIndex; j--) {
				if(array[j].compareTo(array[j-1]) < 0) {
					Util.swap(array, j, j-1);
				}
			}
			
		}
		
		leftIndex++;
		rightIndex--;
		
	}
}