package adt.linkedList;

import java.util.ArrayList;
import java.util.List;


public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
	}


	@Override
	public boolean isEmpty() {
		return (this.getData() == null);
	}

	@Override
	public int size() {
		int cont = 0;
		
		if(!this.isEmpty()){
			cont = 1 + this.getNext().size();
		}
		
		return cont;
	}

	@Override
	public T search(T element) {
		T toReturn = null;
		
		if(this.isEmpty()) {
			return toReturn;
		}
		
		if(this.getData().equals(element)){
			toReturn = this.getData();
		} else {
			toReturn = this.getNext().search(element);
		}
		
		return toReturn;
	}

	@Override
	public void insert(T element) {
		
		if(this.isEmpty()){
			// Último elemento
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.getNext().insert(element);
		}
		
	}

	@Override
	public void remove(T element) {
		
		if(element == null || this.isEmpty()) {
			return;
		}

		if(this.getData().equals(element)){
			if(this.getNext().isEmpty()){
				// Próximo é vazio
				this.setData(null);
				this.setNext(this.getNext().getNext());
			} else{
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			}
		} else {
			this.getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
 		List<T> array = new ArrayList<>();
		auxToArray(array);
		return (T[]) array.toArray();
	}

	private void auxToArray(List<T> array){
		if(this.isEmpty()) {
			return;
		}
		
		array.add(this.getData());
		this.getNext().auxToArray(array);
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
