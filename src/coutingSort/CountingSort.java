package coutingSort;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */

public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex >= rightIndex || rightIndex - leftIndex <= 1) {
			return;
		}
		
		if(leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		// pega o max
		
		Integer max = array[0];
		
		for(int i=leftIndex; i <= rightIndex; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		// cria o array de contador do tamanho do max e inicializa com 0
		
		Integer[] arrayCount = new Integer[max+1];
		
		for(int i=0; i<arrayCount.length; i++) {
			arrayCount[i] = 0;
		}
		
		
		// adiciona todos elementos em suas posições no array aux
		
		for(int i=leftIndex; i<= rightIndex; i++) {
			arrayCount[array[i]]++;
		}
		
		// troca no array principal
		
		Integer leftIterator = leftIndex;
		
		for(int i=0; i<arrayCount.length; i++) {
			
			while(arrayCount[i] > 0) {
				array[leftIterator] = i;
				arrayCount[i] -= 1;
				leftIterator += 1;
			}
			
		}
		
	}
}
