package coutingSort;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

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
		Integer min = array[0];
		
		for(int i=leftIndex; i <= rightIndex; i++) {
			if(max < array[i]) {
				max = array[i];
			}
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		
		// cria o array de contador do tamanho do max - min e inicializa com 0
		
		Integer[] arrayCount = new Integer[(max - min)+1];
		
		for(int i=0; i<arrayCount.length; i++) {
			arrayCount[i] = 0;
		}
		
		
		// adiciona todos elementos em suas posições no array aux
		
		for(int i=leftIndex; i<= rightIndex; i++) {
			arrayCount[array[i] - min]++;
		}
		
		
		// troca no array principal
		
		Integer leftIterator = leftIndex;
		
		for(int i=0; i<arrayCount.length; i++) {
			
			while(arrayCount[i] > 0) {
				array[leftIterator] = i+min;
				arrayCount[i] -= 1;
				leftIterator += 1;
			}
			
		}
		
	}

}

