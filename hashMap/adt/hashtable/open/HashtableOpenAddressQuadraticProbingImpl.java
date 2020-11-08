package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(this.isFull()) {
			throw new HashtableOverflowException();
		}
		
		if(element == null || this.search(element) != null) {
			return;
		}

		int probe = 0;
		int temp = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,probe);
		
		while(this.table[temp] != null){
			
			if(this.table[temp].equals(deletedElement)) {
				break;
			}
			
			temp = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,++probe);
			COLLISIONS++;

		}
		
		this.table[temp] = element;
		elements++;
	}

	@Override
	public void remove(T element) {
		if(element == null || this.isEmpty() || this.search(element) == null) {
			return;
		}
		
		int probe = 0;
		int temp = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,probe);
		
		while (this.table[temp] != null && probe < table.length) {
			
			if(this.table[temp].equals(element)) {
				this.table[temp] = deletedElement;
				COLLISIONS-=probe;
				elements--;
				break;
			}
			
			temp = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, ++probe);
		}
	}

	@Override
	public T search(T element) {
		T toReturn = null;
		
		if(element == null || this.isEmpty()) {
			return toReturn;
		}
		
		int index = indexOf(element);
		if (index != -1) {
			toReturn = (T) this.table[index];
		}
		
		return toReturn;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		
		if(element == null || this.isEmpty()) {
			return index;
		}
		
		int probe = 0;
		int temp = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);

		while (this.table[temp] != null && probe < table.length) {
			
			if(this.table[temp].equals(element)) {
				index = temp;
				break;
			}
			
			temp = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, ++probe);
		}
		
		return index;
	}
}
