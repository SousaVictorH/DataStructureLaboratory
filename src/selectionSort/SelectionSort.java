package selectionSort;

import Utilidade.util;
import sorting.AbstractSorting;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		for(int j=leftIndex; j<=rightIndex; j++) {
			
			int posMin = j;
			
			for(int i=j; i<=rightIndex; i++) {
				
				if(array[i].compareTo(array[posMin]) < 0) {
					posMin = i;
				}
				
			}
			
			if(array[j].compareTo(array[posMin]) > 0) {
				util.swap(array, j, posMin);
			}
			
		}
	}
}
