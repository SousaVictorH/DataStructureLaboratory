package bubbleSort;

import Utilidade.util;
import sorting.AbstractSorting;

public class BidirectionalBubbleSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < (rightIndex/2) + 1; i++) {
			
			for(int j=leftIndex; j<rightIndex; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					util.swap(array, j, j+1);
				}
			}
			
			for(int j=rightIndex; j>leftIndex; j--) {
				if(array[j].compareTo(array[j-1]) < 0) {
					util.swap(array, j, j-1);
				}
			}
			
		}
		
		leftIndex++;
		rightIndex--;
		
	}
}