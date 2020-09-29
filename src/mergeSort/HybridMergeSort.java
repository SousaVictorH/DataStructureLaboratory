package mergeSort;

public class HybridMergeSort {

	public static final int sizeLimit = 4;
	
	public static int MERGESORT_APPLICATIONS = 0;
	public static int INSERTIONSORT_APPLICATIONS = 0;

	public static void hybridMergeSort(int[] array, int leftIndex, int rightIndex) {
		
		if(rightIndex-leftIndex <= sizeLimit) {
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
	
	private static int insertionSort(int[] array, int leftIndex, int rightIndex) {
		
		INSERTIONSORT_APPLICATIONS += 1;
		int x,j;
		
		for(int i=leftIndex+1; i <= rightIndex; i++) {
			
			x = array[i];
			j = i - 1;
			
			while((j >= 0) && (array[j] > x)) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = x;
		}
		return 0;
	}
	
	private static void merge(int[] array, int leftIndex, int meio, int rightIndex) {
		
		MERGESORT_APPLICATIONS += 1;
		
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
