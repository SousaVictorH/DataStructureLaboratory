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
		if(element == null) return;

		DoubleLinkedListNode<T> newElement = new DoubleLinkedListNode();
		newElement.setData(element);
		newElement.setNext(new DoubleLinkedListNode<>());
		newElement.setPrevious(this.getLast());

		this.getLast().setNext(newElement);

		if(this.isEmpty()){
			this.setHead(newElement);
		}
		this.setLast(newElement);
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
				DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
				newHead.setData(element);
				newHead.setNext(this.head);
				newHead.setPrevious(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);

				if (this.isEmpty()) {
					this.setLast(newHead);
				}
				this.setHead(newHead);
			}
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty() || element == null) return;
		if(this.head.getData().equals(element))this.removeFirst();
		else{
			DoubleLinkedListNode<T> currentElement = (DoubleLinkedListNode) this.getHead().getNext();

			while(!currentElement.isNIL() && !currentElement.getData().equals(element)) {
				currentElement = (DoubleLinkedListNode<T>) currentElement.getNext();
			}
				if(!currentElement.isNIL()){
					if(currentElement.getNext().isNIL()) {
						this.removeLast();
					} else {
						currentElement.getPrevious().setNext(currentElement.getNext());
						((DoubleLinkedListNode<T>)currentElement.getNext()).setPrevious(currentElement.getPrevious());
					}
			}
		}
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) return;
		if(!this.getHead().isNIL()){
			this.head = this.head.getNext();

			if(this.head.isNIL()){
				this.last = (DoubleLinkedListNode<T>) this.head;
			}
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
		}
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
