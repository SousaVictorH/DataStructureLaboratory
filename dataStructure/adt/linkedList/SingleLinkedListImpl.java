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
		int cont = 0;

		if(isEmpty()) {
			return cont;
		}

		SingleLinkedListNode<T> iteratorNode = this.head;
		
		while(!iteratorNode.isNIL()){
			cont++;
			iteratorNode = iteratorNode.getNext();
		}

		return cont;
	}

	@Override
	public T search(T element) {
		T wanted = null;

		if(isEmpty() || element == null) {
			return wanted;	
		}

		SingleLinkedListNode<T> currentNode = this.head;

		while(currentNode != null){
			if(element.equals(currentNode.getData())){
				wanted = currentNode.getData();
				break;
			}else{
				currentNode = currentNode.getNext();
			}
		}
		
		return wanted;
	}

	@Override
	public void insert(T element) {
		if(element == null) {
			return;
		}

		SingleLinkedListNode<T> currentNode = this.head;
		SingleLinkedListNode<T> toInsertNode = new SingleLinkedListNode<T>();
		toInsertNode.setData(element);
		toInsertNode.setNext(new SingleLinkedListNode());

		if(this.head.isNIL()){

			this.setHead(toInsertNode);

		} else{
			while(!currentNode.getNext().isNIL()){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(toInsertNode);
		}
	}

	@Override
	public void remove(T element) {
		if(element == null || isEmpty()) {
			return;
		}

		if(this.head.getData().equals(element)){
			this.head = this.head.getNext();
			return;
		}

		SingleLinkedListNode<T> currentNode = this.head.getNext();
		SingleLinkedListNode<T> prevNode = this.head;

		while(!currentNode.isNIL()){
			if(currentNode.getData().equals(element)){
				prevNode.setNext(currentNode.getNext());
				break;
			}
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}
	}

	@Override
	public T[] toArray() {
		T[] lista = (T[]) new Comparable[this.size()];
		
		if(isEmpty()) {
			return lista;
		}

		SingleLinkedListNode<T> newElement = this.head;
		int i = 0;
		while(!newElement.isNIL()){
			lista[i++] = newElement.getData();
			newElement = newElement.getNext();
		}

		return lista;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
