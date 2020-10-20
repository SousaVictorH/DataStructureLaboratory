package dividireConquistar;

import sorting.AbstractSorting;

public class HybridMergeSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	/**
	* For inputs with size less or equal to this value, the insertionsort
	* algorithm will be used instead of the mergesort.
	*/
	public static final int SIZE_LIMIT = 4;
	
	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
	
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		hybridMergeSort(array, leftIndex, rightIndex);
		
		System.out.println(MERGESORT_APPLICATIONS);
		System.out.println(INSERTIONSORT_APPLICATIONS);
	}
	
	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
	
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		if(rightIndex-leftIndex <= SIZE_LIMIT) {
			insertionSort(array, leftIndex, rightIndex);
			return;
		}
		
		if (rightIndex > leftIndex) {
			int mid = (leftIndex+rightIndex)/2;
			
			hybridMergeSort(array, leftIndex, mid);
			hybridMergeSort(array, mid, rightIndex);
		    
		    merge(array, leftIndex, mid, rightIndex);
		}
	
	}
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
	
		INSERTIONSORT_APPLICATIONS++;
		
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
		
		insertionSort(array, leftIndex+1, rightIndex);
	
	}
	
	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {
	
		MERGESORT_APPLICATIONS++;
		
		T[] leftArray = (T[]) new Comparable[mid - leftIndex+1];
		T[] rightArray = (T[]) new Comparable[rightIndex - mid];
		
		for (int i = 0; i < leftArray.length; i++)
		    leftArray[i] = array[leftIndex + i];
		for (int i = 0; i < rightArray.length; i++)
		    rightArray[i] = array[mid + i + 1];
		
		int leftIterator = 0, rightIterator = 0;
		
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			
			if(rightIterator >= rightArray.length) {
		        array[i] = leftArray[leftIterator];
		        leftIterator++;
		        continue;
			}
			
			if(leftIterator >= leftArray.length) {
		        array[i] = rightArray[rightIterator];
		        rightIterator++;
		        continue;
			}
			
		    if ((leftArray[leftIterator].compareTo(rightArray[rightIterator])) < 0) {
		        array[i] = leftArray[leftIterator];
		        leftIterator++;
		     } else {
		         array[i] = rightArray[rightIterator];
		         rightIterator++;
		     }
		    
		}
	
	}
}
