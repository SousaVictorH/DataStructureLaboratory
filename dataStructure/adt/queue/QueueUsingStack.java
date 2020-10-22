package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		try {
			
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			
			stack1.push(element);
			
			while(!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			
		} catch(Exception e) {
			
			throw new QueueOverflowException();
			
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		try {
			
			return stack1.pop();
			
		}catch(Exception e){
			
			throw new QueueUnderflowException();
			
		}
		
	}

	@Override
	public T head() {
		
		return stack1.top();
		
	}

	@Override
	public boolean isEmpty() {
		
		return stack1.isEmpty();
		
	}

	@Override
	public boolean isFull() {
		
		return stack1.isFull();
		
	}

}
