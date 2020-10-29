package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insert(T element) {
		if( element != null){
			if(!this.isEmpty()){
				this.getNext().insert(element);
			} else {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if(element!= null){
			if(this.isEmpty()){
				this.setData(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> list = new RecursiveDoubleLinkedListImpl<>();
				list.setData(this.getData());
				list.setPrevious(this);
				list.setNext(this.getNext());

				this.setNext(list);
				this.setData(element);
			}

		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()){
			if(this.getData().equals(element)){
				if(this.getPrevious().isEmpty()){
					this.removeFirst();
				} else if (this.getNext().isEmpty()){
					this.removeLast();
				} else {
					this.getPrevious().setNext(this.getNext());
					((RecursiveDoubleLinkedListImpl) this.getNext()).setPrevious(this.getPrevious());
				}
			} else {
				this.getNext().remove(element);
			}

		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(this.getNext().isEmpty()){
				this.setData(null);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
			} else {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.getNext().isEmpty()){
				this.setData(null);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
			} else {
				((RecursiveDoubleLinkedListImpl) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
