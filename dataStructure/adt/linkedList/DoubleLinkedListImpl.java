package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl () {
		this.setHead(new DoubleLinkedListNode<>());
		this.setLast((DoubleLinkedListNode<T>) this.head);
	}

	@Override
	public void insert(T element) {
		if(element == null) {
			return;
		}

		DoubleLinkedListNode<T> toInsertNode = new DoubleLinkedListNode();
		toInsertNode.setData(element);
		
		toInsertNode.setNext(new DoubleLinkedListNode<>());
		toInsertNode.setPrevious(this.getLast());
		this.getLast().setNext(toInsertNode);
		
		this.setLast(toInsertNode);
		
		if(this.isEmpty()){
			this.setHead(toInsertNode);
		}
	}

	@Override
	public void insertFirst(T element) {
		if(element == null) {
			return;
		}
		
		DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<>();
		
		newHeadNode.setData(element);
		
		newHeadNode.setNext(this.head);
		newHeadNode.setPrevious(new DoubleLinkedListNode<>());
		((DoubleLinkedListNode<T>) this.head).setPrevious(newHeadNode);

		this.setHead(newHeadNode);
		
		if (this.isEmpty()) {
			this.setLast(newHeadNode);
		}
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty() || element == null) {
			return;
		}
		
		if(this.head.getData().equals(element)) {
			this.removeFirst();
		}
		else{
			DoubleLinkedListNode<T> currentNode = (DoubleLinkedListNode) this.getHead().getNext();

			while(!currentNode.isNIL()) {
				
				if(currentNode.getData().equals(element)) {
					if(currentNode.getNext().isNIL()) {
						this.removeLast();
					} else {
						currentNode.getPrevious().setNext(currentNode.getNext());
						((DoubleLinkedListNode<T>)currentNode.getNext()).setPrevious(currentNode.getPrevious());
					}
					break;
				}
				
				currentNode = (DoubleLinkedListNode<T>) currentNode.getNext();
			}
			
		}
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty() || this.head.isNIL()) {
			return;
		}
		
		this.head = this.head.getNext();

		if(this.head.isNIL()){
			this.last = (DoubleLinkedListNode<T>) this.head;
		}
		
		((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
	}

	@Override
	public void removeLast() {
		
		if(!this.isEmpty()){
			this.setLast(this.last.getPrevious());
		} if(this.last.isNIL()){
			this.head = this.last;
		}
		
		this.last.setNext(new DoubleLinkedListNode<T>());
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
