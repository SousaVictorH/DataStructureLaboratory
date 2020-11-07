package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(this.isFull()) {
			throw new HashtableOverflowException();
		}
		
		if(element == null || search(element) != null) {
			return;
		}

		int probe = 0;
		int temp = ((HashFunctionLinearProbing)this.hashFunction).hash(element,probe);
		
		while(this.table[temp] != null){
			
			if(this.table[temp].equals(deletedElement)) {
				break;
			}
			
			temp = ((HashFunctionLinearProbing)this.hashFunction).hash(element,++probe);
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
		int temp = ((HashFunctionLinearProbing)this.hashFunction).hash(element,probe);
		
		while (probe < table.length && this.table[temp] != null) {
			
			if(this.table[temp].equals(element)) {
				this.table[temp] = deletedElement;
				COLLISIONS-=probe;
				elements--;
				break;
			}
			
			temp = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
		}
	}

	@Override
	public T search(T element) {
		T toReturn = null;
		
		if(element == null || this.isEmpty()) {
			return toReturn;
		}
		
		int position = indexOf(element);
		
		if (position != -1) {
			toReturn = (T) this.table[position];
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
		int temp = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

		while (probe < table.length && this.table[temp] != null) {
			
			if(this.table[temp].equals(element)) {
				index = temp;
				break;
			}
			
			temp = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
			
		}
		
		return index;
	}

}
