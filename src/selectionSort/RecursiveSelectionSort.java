package selectionSort;

import Utilidade.util;
import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		if(leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex > array.length || leftIndex == rightIndex) {
			return;
		}
		
		int posMin = leftIndex;
		
		for(int i=leftIndex; i<=rightIndex; i++) {
			
			if(array[i].compareTo(array[posMin]) < 0) {
				posMin = i;
			}
			
		}
		
		if(array[leftIndex].compareTo(array[posMin]) > 0) {
			util.swap(array, leftIndex, posMin);
		}
		
		sort(array, leftIndex+1, rightIndex);
	}

}