package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer toReturn = null;
		
		if(array.length <= 0) return toReturn;
		
		fillHeap(array);
		
		if(comparator.compare(1, 2) > 0) {
			toReturn = minHeapFloor(numero);
		} else {
			toReturn = maxHeapFloor(numero);
		}
		
		return toReturn;
	}
	
	private Integer maxHeapFloor(double numero) {
		Integer toReturn = null;
		
		if(!this.isEmpty()) {
			
			if(this.rootElement() == numero) {
				
				return this.rootElement();
				
			}else if(this.rootElement() < numero) {
				
				toReturn = this.extractRootElement();
				Integer aux = maxHeapFloor(numero);
				
				if(aux != null && aux > toReturn) {
					toReturn = aux;
				}
				
			} else {
				
				this.extractRootElement();
				toReturn = maxHeapFloor(numero);
				
			}
			
		}
		
		return toReturn;
	}
	
	private Integer minHeapFloor(double numero) {
		Integer toReturn = null;
		
		if(!this.isEmpty()) {
			if(this.rootElement() == numero) {
				
				return this.rootElement();
				
			}else if(this.rootElement() > numero) {
				
				this.extractRootElement();
				toReturn = minHeapFloor(numero);
				
			} else {
				
				toReturn = this.extractRootElement();
				Integer aux = minHeapFloor(numero);
				if(aux != null && aux > toReturn) {
					toReturn = aux;
				}
				
			}
		}
		
		return toReturn;
	}
	
	private void fillHeap(Integer[] array) {
		
		this.heap = new Integer[array.length];
		this.index = -1;
		
		for(int i=0; i<array.length; i++) {
			this.insert(array[i]);
		}
		
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer toReturn = null;
		
		if(array.length <= 0) return toReturn;
		
		fillHeap(array);
		
		if(comparator.compare(1, 2) > 0) {
			toReturn = minHeapCeil(numero);
		} else {
			toReturn = maxHeapCeil(numero);
		}
		
		return toReturn;
	}
	
	private Integer maxHeapCeil(double numero) {
		Integer toReturn = null;
		
		if(!this.isEmpty()) {
			if(this.rootElement() == numero) {
				
				return this.rootElement();
				
			}else if(this.rootElement() > numero) {
				
				toReturn = this.extractRootElement();
				Integer aux = maxHeapCeil(numero);
				
				if(aux != null && aux < toReturn) {
					toReturn = aux;
				}
				
			} else {
				
				this.extractRootElement();
				toReturn = maxHeapCeil(numero);
				
			}
		}
		
		return toReturn;
	}
	
	private Integer minHeapCeil(double numero) {
		Integer toReturn = null;
		
		if(!this.isEmpty()) {
			if(this.rootElement() == numero) {
				return this.rootElement();
			}else if(this.rootElement() > numero) {
				toReturn = this.extractRootElement();
				Integer aux = minHeapCeil(numero);
				
				if(aux != null && aux < toReturn) {
					toReturn = aux;
				}
			} else {
				this.extractRootElement();
				toReturn = minHeapCeil(numero);
			}
		}
		
		return toReturn;
	}

}
