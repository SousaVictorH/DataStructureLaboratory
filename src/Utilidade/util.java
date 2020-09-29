package Utilidade;

public class util {

	public static void swap(int[] v, int i, int j) {
		
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}
	
	public static int[] combinaVetor(int[] A, int[] B) {
		
		int array[] = new int[A.length + B.length];
		
		int iteratorA = 0;
		int iteratorB = B.length-1;
		
		for(int i=0; i<array.length; i++) {
			
			if(iteratorB < 0) {
				array[i] = A[iteratorA++];
				continue;
			}
			
			if(iteratorA >= A.length) {
				array[i] = A[iteratorB--];
				continue;
			}

			if(A[iteratorA] <= B[iteratorB]) {
				array[i] = A[iteratorA++];
			}else {
				array[i] = B[iteratorB--];
			}

			
		}
		
		return array;
	}
	
}
