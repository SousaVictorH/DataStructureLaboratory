package mergeSort;

import sorting.AbstractSorting;
	
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		if (rightIndex > leftIndex) {
				
			   int mid = (leftIndex+rightIndex)/2;
			    
			   sort(array, leftIndex, mid);
			   sort(array, mid+1, rightIndex);
			    
			   merge(array, leftIndex, mid, rightIndex);
			    
		}
			
	}
	
	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {
		
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
