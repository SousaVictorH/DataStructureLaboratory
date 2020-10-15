package estatisticaDeOrdem;

import Utilidade.util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		
		T[] aux = (T[]) new Comparable[k];
		int j = 0;
		
		for(int i=array.length-k+1; i<=array.length; i++) {
			
			aux[j] = orderStatistics(array, i);
			j++;
		}
		
		return aux;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	private T orderStatistics(T[] array, int i) {
		return quickSelect(array, i);
	}
	
	public T quickSelect(T[] array, int k) {
		
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
