package estatisticaDeOrdem;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso redua a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
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
