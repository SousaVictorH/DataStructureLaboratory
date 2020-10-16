package estatisticaDeOrdem;

import Utilidade.util;

public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		
		T[] aux = (T[]) new Comparable[k];
		int ponteiro = 0;
		
		for(int i=array.length-k+1; i<=array.length; i++) {
			
			aux[ponteiro] = orderStatistics(array, i);
			ponteiro++;
		}
		
		return aux;
	}

	private T orderStatistics(T[] array, int i) {
		return quickSelect(array, i);
	}
	
	private T quickSelect(T[] array, int k) {
		
		if( (array.length < 1) || (k<=0) || (k > array.length) ) {
			return null;
		}else {
			return quickSelect(array, 0, array.length-1, k);	
		}
		
	}

	private T quickSelect(T[] array, int leftIndex, int rightIndex, int k){
		
		if(leftIndex <= rightIndex) {
			
			if(leftIndex == rightIndex) {
				return array[leftIndex];
			}
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			
			if(k < pivotIndex+1){
				return quickSelect(array, leftIndex, pivotIndex-1, k);
			}else if(k > pivotIndex+1 ) {
				return quickSelect(array, pivotIndex+1, rightIndex, k);
			} else{
				return array[pivotIndex];
			}
		}
		
		return null;

		
	}
	
    private int partition(T[] array, int leftIndex, int rightIndex) {
		
        int pivotIndex = getPivot(array, leftIndex, rightIndex);
        
        T pivo = array[pivotIndex];
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
    
    private int getPivot(T[] array, int leftIndex, int rightIndex) {
    	
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
        
    	return rightIndex;
    }
}
