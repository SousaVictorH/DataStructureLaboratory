package buscaBinaria;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		// ORDENANDO
		quickSort(array, 0, array.length-1);
		
		return floor(array, x, 0, array.length-1);
		
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		
		Integer ret = null;
		
		// VERIFICANDO LIMITES
		if(leftIndex > rightIndex) {
			return ret;
		}
		
		int mid = (leftIndex + rightIndex)/2;
		
		// PROCURANDO NA ESQUERDA CASO O ELEMENTO PROCURADO SEJA MENOR
		if(array[mid] < x) {
			
			Integer aux = array[mid];
			
			ret = floor(array, x, mid+1, rightIndex);
			
			if(ret == null) {
				return aux;
			}
		// PROCURANDO NA DIREITA CASO O ELEMENTO PROCURADO SEJA MAIOR
		}else if(array[mid] > x) {
			
			ret = floor(array, x, leftIndex, mid-1);
		// RETORNANDO O ELEMENTO SE ELE FOR IGUAL
		}else {
			
			ret =  x;
			
		}
		
		return ret;
	}
	
	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		
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
        
        quickSort(array, leftIndex, q - 1);
        quickSort(array, q + 1, rightIndex);  
	}   
    
    private int partition(Integer[] array, int leftIndex, int rightIndex) {
		
        int pivotIndex = getPivot(array, leftIndex, rightIndex);
        
        Integer pivo = array[pivotIndex];
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
    
    private int getPivot(Integer[] array, int leftIndex, int rightIndex) {
    	
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
