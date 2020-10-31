package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}

	@Override
	public void insert(T element) {
		if(element == null) {
			return;
		}
		
		if(this.getNext() != null) {
			
			this.getNext().insert(element);
			
		} else {
			// Último elemento
			if(this.getPrevious() == null){
				//Primeiro elemento (lista com size 1)
				this.insertFirst(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> toInsertList = new RecursiveDoubleLinkedListImpl<>();
				this.setData(element);
				this.setNext(toInsertList);
				toInsertList.setPrevious(this);
			}
			
		}
	}

	@Override
	public void insertFirst(T element) {
		if(element == null) {
			return;
		}
		
		if(this.isEmpty()){
			// Lista vazia
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<>());
			((RecursiveDoubleLinkedListImpl<T>)this.getNext()).setPrevious(this);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
			
		} else {
			
			RecursiveDoubleLinkedListImpl<T> toInsertList = new RecursiveDoubleLinkedListImpl<>();
			
			toInsertList.setData(this.getData());
			toInsertList.setNext(this.getNext());
			toInsertList.setPrevious(this);

			this.setNext(toInsertList);
			this.setData(element);

			((RecursiveDoubleLinkedListImpl<T>)toInsertList.getNext()).setPrevious(toInsertList);

		}
	}

	@Override
	public void remove(T element) {
		if(element == null || this.isEmpty()) {
			return;
		}
		
		if(this.getData().equals(element)){
			
			if(this.getPrevious().isEmpty()){
				// Primeiro elemento
				this.removeFirst();
			} else if (this.getNext().isEmpty()){
				// Ultimo elemento
				this.removeLast();
			} else {
				this.getPrevious().setNext(this.getNext());
				((RecursiveDoubleLinkedListImpl) this.getNext()).setPrevious(this.getPrevious());
			}
			
		} else {
			this.getNext().remove(element);
		}
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			return;
		}
		
		if(this.getNext().isEmpty()){
			// Lista com um único elemento
			this.setData(null);
			this.setNext(new RecursiveDoubleLinkedListImpl<>());
		} else {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
		}
	}

	@Override
	public void removeLast() {
		if(this.isEmpty()) {
			return;
		}
		
		if(this.getNext().isEmpty()){
			// Último elemento
			this.setData(null);
			this.setNext(null);
		} else {
			((RecursiveDoubleLinkedListImpl) this.getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
