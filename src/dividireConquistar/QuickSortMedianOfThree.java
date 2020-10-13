package dividireConquistar;

import Utilidade.util;
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
		
        int meio = (leftIndex + rightIndex)/2;
        
        if(array[leftIndex].compareTo(array[meio]) > 0) {
        	util.swap(array, leftIndex, meio);
        }      
        if(array[rightIndex].compareTo(array[leftIndex]) < 0) {
        	util.swap(array, rightIndex, leftIndex);
        }     
        if(array[rightIndex].compareTo(array[meio]) < 0) {
        	util.swap(array, leftIndex, meio);
        }
        
        util.swap(array, meio, rightIndex-1);
        
        T pivo = array[rightIndex];
        int i = leftIndex;
        
        for(int j = leftIndex; j < rightIndex; j++){
        	
            if(array[j].compareTo(pivo) <= 0){
            	util.swap(array, i, j);
                i++;
            }
            
        }
        
        util.swap(array, i , rightIndex);
        return i;
	} 
}
