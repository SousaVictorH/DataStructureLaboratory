package estatisticaDeOrdem;

import Utilidade.util;

public class QuickSelect<T extends Comparable<T>> {

	public T quickSelect(T[] array, int k) {
		
		// VERIFICANDO LIMITES
		if( (array.length < 1) || (k<=0) || (k > array.length) ) {
			return null;
		}
		
		return quickSelect(array, 0, array.length-1, k);	
		
		
	}

	private T quickSelect(T[] array, int leftIndex, int rightIndex, int k){
		
		//VERIFICANDO LIMITES
		if(leftIndex <= rightIndex) {
			//PARA UM ARRAY DE 1 POSICAO A RESPOSTA É ELE MESMO
			if(leftIndex == rightIndex) {
				return array[leftIndex];
			}
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			
			//ESTRATEGIA DE QUICK SORT
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
