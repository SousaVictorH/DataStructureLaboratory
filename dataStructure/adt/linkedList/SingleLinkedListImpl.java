package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int contador = 0;
		SingleLinkedListNode<T> newElement = this.head;

		if(isEmpty()) return contador;

		while(!newElement.isNIL()){
			contador++;
			newElement = newElement.getNext();
		}

		return contador;
	}

	@Override
	public T search(T element) {
		T wanted = null;

		if(isEmpty()) return wanted;

		if(element != null){
			SingleLinkedListNode<T> newElement = this.head;

			while(newElement != null){
				if(element.equals(newElement.getData())){
					wanted = newElement.getData();
					break;
				}else newElement = newElement.getNext();
			}
		}
		return wanted;
	}

	@Override
	public void insert(T element) {
		if(element == null) return;

		SingleLinkedListNode<T> currentElement = this.head;
		SingleLinkedListNode<T> insertElement = new SingleLinkedListNode<T>();
		insertElement.setData(element);
		insertElement.setNext(new SingleLinkedListNode());

		if(this.head.isNIL()){

			this.setHead(insertElement);

		} else{
			while(!currentElement.getNext().isNIL()){
				currentElement = currentElement.getNext();
			}
			currentElement.setNext(insertElement);
		}
	}

	@Override
	public void remove(T element) {
		if(element == null || isEmpty()) return;

		if(this.head.getData().equals(element)){
			this.head = this.head.getNext();
			return;
		}

		SingleLinkedListNode<T> currentElement = this.head.getNext();
		SingleLinkedListNode<T> prevElement = this.head;

		while(!currentElement.isNIL()){
			if(currentElement.getData().equals(element)){
				prevElement.setNext(currentElement.getNext());
				break;
			} else {
				prevElement = currentElement;
				currentElement = currentElement.getNext();
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		if(isEmpty()) return array;

		SingleLinkedListNode<T> newElement = this.head;
		int i = -1;
		while(!newElement.isNIL()){
			array[++i] = newElement.getData();
			newElement = newElement.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
