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
		int hashElement = ((HashFunctionLinearProbing)this.hashFunction).hash(element,probe);
		
		while(this.table[hashElement] != null){
			
			if(this.table[hashElement].equals(deletedElement)) {
				break;
			}
			
			hashElement = ((HashFunctionLinearProbing)this.hashFunction).hash(element,++probe);
			COLLISIONS++;
		}
		this.table[hashElement] = element;
		elements++;
	}

	@Override
	public void remove(T element) {
		if(element == null || this.isEmpty() || this.search(element) == null) {
			return;
		}
		
		int probe = 0;
		int hashElement = ((HashFunctionLinearProbing)this.hashFunction).hash(element,probe);
		
		while (probe < table.length && this.table[hashElement] != null) {
			
			if(this.table[hashElement].equals(element)) {
				this.table[hashElement] = deletedElement;
				COLLISIONS-=probe;
				elements--;
				break;
			}
			
			hashElement = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
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
		int hashElement = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

		while (probe < table.length && this.table[hashElement] != null) {
			
			if(this.table[hashElement].equals(element)) {
				index = hashElement;
				break;
			}
			
			hashElement = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
			
		}
		
		return index;
	}

}
