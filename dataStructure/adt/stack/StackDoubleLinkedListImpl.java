package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.isFull()) {
			throw new StackOverflowException();
		}

		if(element == null) {
			return;
		}
		
		this.top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw  new StackUnderflowException();
		}

		T toReturn = this.top();
		this.top.removeLast();
		return toReturn;
	}

	@Override
	public T top() {
		T toReturn;
		
		if(this.top.isEmpty()) {
			toReturn = null;
		}else {
			toReturn = ((DoubleLinkedListImpl<T>)this.top).getLast().getData();
		}
		
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (this.size == this.top.size());
	}

}
