package quickSort;

import Utilidade.util;

public class QuicksortMedianaDeTres {

    public static void quicksortMedianaDeTres(int[] A, int leftIndex, int rightIndex){
    	
    	if(rightIndex <= leftIndex) {
    		return;
    	}
    	
        int q = partition(A, leftIndex, rightIndex);
        
        quicksortMedianaDeTres(A, leftIndex, q - 1);
        quicksortMedianaDeTres(A, q + 1, rightIndex);  
        
    }
    
    
    private static int partition(int[] A, int inicio, int fim){
        
        int meio = (inicio + fim)/2;
        
        if(A[inicio] > A[meio]) {
        	util.swap(A, inicio, meio);
        }      
        if(A[fim] < A[inicio]) {
        	util.swap(A, fim, inicio);
        }     
        if(A[fim] < A[meio]) {
        	util.swap(A, inicio, meio);
        }
        
        util.swap(A, meio, fim-1);
        
        int pivo = A[fim];
        int i = inicio;
        
        for(int j = inicio; j < fim; j++){
        	
            if(A[j] <= pivo){
            	util.swap(A, i, j);
                i++;
            }
            
        }
        
        util.swap(A, i , fim);
        return i;
    }    
}
