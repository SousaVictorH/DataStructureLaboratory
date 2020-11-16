package dividireConquistar;

import util.Util;
import sorting.AbstractSorting;

public class QuickSortMedianOfThree<T extends Comparable<T>> extends
AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex || leftIndex > rightIndex) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
    	if(rightIndex <= leftIndex) {
    		return;
    	}
    	
        int q = partition(array, leftIndex, rightIndex);
        
        sort(array, leftIndex, q - 1);
        sort(array, q + 1, rightIndex);  
	}   
    
    private int partition(T[] array, int leftIndex, int rightIndex) {
		
        int pivotIndex = getPivot(array, leftIndex, rightIndex);
        
        T pivo = array[pivotIndex];
        int i = leftIndex;
        
        for(int j = leftIndex; j < rightIndex; j++){
        	
            if(array[j].compareTo(pivo) <= 0){
            	Util.swap(array, i, j);
                i++;
            }
            
        }
        
        Util.swap(array, i , rightIndex);
        return i;
	}
    
    private int getPivot(T[] array, int leftIndex, int rightIndex) {
    	
        int meio = (leftIndex + rightIndex)/2;
        
        if(array[leftIndex].compareTo(array[meio]) > 0) {
        	Util.swap(array, leftIndex, meio);
        }      
        if(array[rightIndex].compareTo(array[leftIndex]) < 0) {
        	Util.swap(array, rightIndex, leftIndex);
        }     
        if(array[rightIndex].compareTo(array[meio]) < 0) {
        	Util.swap(array, leftIndex, meio);
        }
        
        Util.swap(array, meio, rightIndex-1);
        
    	return rightIndex;
    }
}
