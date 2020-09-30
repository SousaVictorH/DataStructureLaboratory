package bubbleSort;

import Utilidade.util;
import sorting.AbstractSorting;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			for(int j = rightIndex; j > i ; j--) {
				
				if(array[j].compareTo(array[j-1]) < 0) {
					
					util.swap(array, j, j-1);
					
				}
				
			}
			
		}
		
	}
}