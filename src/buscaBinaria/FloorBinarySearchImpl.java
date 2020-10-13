package buscaBinaria;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		return floor(array, x, 0, array.length-1);
		
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		
		Integer ret = null;
		
		if(leftIndex > rightIndex) {
			return ret;
		}
		
		int mid = (leftIndex + rightIndex)/2;
		
		if(array[mid] < x) {
			
			Integer aux = array[mid];
			
			ret = floor(array, x, mid+1, rightIndex);
			
			if(ret == null) {
				return aux;
			}
			
		}else if(array[mid] > x) {
			
			ret = floor(array, x, leftIndex, mid-1);
			
		}else {
			
			ret =  x;
			
		}
		
		return ret;
	}

}
