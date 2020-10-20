package dividireConquistar;

import Utilidade.util;

import sorting.AbstractSorting;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		if(leftIndex < rightIndex) {
			int j = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, j-1);
			sort(array, j+1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		T pivo = array[rightIndex];
		int i = leftIndex;
		
		for(int j=leftIndex; j<rightIndex; j++) {
			
			if(array[j].compareTo(pivo) <= 0) {
				util.swap(array, i, j);
				i++;
			}
			
		}
		
		util.swap(array, i, rightIndex);
		
		return i;
	}

}
