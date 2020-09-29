package mergeSort;

public class MergeSort {

	public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
	    
		if (rightIndex > leftIndex) {
			
		    int mid = (leftIndex+rightIndex)/2;
		    
		    mergeSort(array, leftIndex, mid);
		    mergeSort(array, mid+1, rightIndex);
		    
		    merge(array, leftIndex, mid, rightIndex);
		    
		}
	}

	private static void merge(int[] array, int leftIndex, int meio, int rightIndex) {
		
	    int leftArray[] = new int[meio - leftIndex + 1];
	    int rightArray[] = new int[rightIndex - meio];

	    for (int i = 0; i < leftArray.length; i++)
	        leftArray[i] = array[leftIndex + i];
	    for (int i = 0; i < rightArray.length; i++)
	        rightArray[i] = array[meio + i + 1];

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
	    	
	        if (leftArray[leftIterator] < rightArray[rightIterator]) {
	            array[i] = leftArray[leftIterator];
	            leftIterator++;
	         } else {
	             array[i] = rightArray[rightIterator];
	             rightIterator++;
	         }
	        
	    }
	    
	}
	
}
