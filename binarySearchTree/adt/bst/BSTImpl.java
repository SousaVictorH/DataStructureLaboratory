package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {	
		return this.height(this.root);
	}

	private int height (BTNode<T> node) {
		
		if(node.isEmpty()) {
			return -1;
		} else {
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		
	}

	@Override
	public BSTNode<T> search(T element) {
		
		BSTNode<T> result = new BSTNode<>();

		if(element != null && !this.isEmpty()) {
			result = search(this.root, element);
		}
		
		return result;
		
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		
		BSTNode<T> aux = new BSTNode<>();

		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				aux = node;
			} else if (node.getData().compareTo(element) < 0) {
				aux = search((BSTNode<T>) node.getRight(), element);
			} else {
				aux = search((BSTNode<T>) node.getLeft(), element);
			}
		}

		return aux;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert (BSTNode<T> node, T element) {
		
		if (node.isEmpty()) {
			
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			
		} else {
			
			if (node.getData().compareTo(element) < 0) {
				insert((BSTNode<T>) node.getRight(), element);
			} else if(node.getData().compareTo(element) > 0){
				insert((BSTNode<T>) node.getLeft(), element);
			}
			
		}
	}

	@Override
	public BSTNode<T> maximum() {
		
		if (this.isEmpty()) {
			return null;
		} else {
			return maximum(this.root);
		}
		
	}

	private BSTNode<T> maximum(BSTNode<T> node){
		
		while(!node.getRight().isEmpty()) {
			node = (BSTNode<T>) node.getRight();
		}
		
		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		
		if(this.isEmpty()) {
			return null;
		} else {
			return minimum(this.root);
		}
		
	}

	private BSTNode<T> minimum(BSTNode<T> node){
		
		while(!node.getLeft().isEmpty()) {
			node = (BSTNode<T>) node.getLeft();
		}
		
		return node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		
		BSTNode<T> sucessor = search(element);

		if(element == null || sucessor.isEmpty()) {
			
			return null;
			
		} else {
			
			if (!sucessor.getRight().isEmpty()) {
				sucessor = minimum((BSTNode<T>) sucessor.getRight());
			} else {
				sucessor = sucessor(sucessor);
			}
			
		}

		return sucessor;
		
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		
		BSTNode<T> sucessor = (BSTNode<T>) node.getParent();

		if(node.getParent() == null) {
			
			return sucessor;
			
		} else {
			
			if (!sucessor.isEmpty() && sucessor.getRight().equals(node)) {
				sucessor = sucessor((BSTNode<T>) node.getParent());
			}

			return sucessor;	
		}
		
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		
		BSTNode<T> predecessor = search(element);
		
		if(element == null || predecessor.isEmpty()) {
			return null;
		} else {
			
			if (!predecessor.getLeft().isEmpty()) {
				predecessor = maximum((BSTNode<T>) predecessor.getLeft());
			} else {
				predecessor = predecessor(predecessor);
			}
			
		}

		return predecessor;
	}

	private BSTNode<T> predecessor (BSTNode<T> node) {
		BSTNode<T> predecessor = (BSTNode<T>) node.getParent();

		if(node.getParent() == null) {
			return predecessor;
		} else {
			
			if (!predecessor.isEmpty() && predecessor.getLeft().equals(node)) {
				predecessor = predecessor((BSTNode<T>) node.getParent());
			}
			return predecessor;	
		}
		
	}

	@Override
	public void remove(T element) {
		BSTNode<T> toRemove = search(element);
		
		if(toRemove.isEmpty()) return;
		
		if(toRemove.isLeaf()) {
			
			if(toRemove.equals(root)) {
				this.root.setData(null);
			} else {
				if(toRemove.getData().compareTo(toRemove.getParent().getData()) < 0) {
					toRemove.setData(null);
					toRemove.setLeft(null);
				} else {
					toRemove.setData(null);
					toRemove.setRight(null);
				}
				
			}
			
		} else if(toRemove.getRight().isEmpty() || toRemove.getLeft().isEmpty()) {
			
			BSTNode<T> parent = (BSTNode<T>) toRemove.getParent();

			if (parent != null) {
				
				if (!parent.getLeft().equals(toRemove)) {
					
					if (!toRemove.getLeft().isEmpty()) {
						parent.setRight(toRemove.getLeft());
						toRemove.getLeft().setParent(parent);
					} else {
						parent.setRight(toRemove.getRight());
						toRemove.getRight().setParent(parent);
					}

				} else {
					
					if (!toRemove.getLeft().isEmpty()) {
						parent.setLeft(toRemove.getLeft());
						toRemove.getLeft().setParent(parent);
					} else {
						parent.setLeft(toRemove.getRight());
						toRemove.getRight().setParent(parent);
					}
					
				}
				
			} else {
				
				if (!toRemove.getLeft().isEmpty()) {
					this.root = (BSTNode<T>) toRemove.getLeft();
				} else {
					this.root = (BSTNode<T>) toRemove.getRight();
				}
				
				this.root.setParent(null);
				
			}
			
		} else {
			T sucessor = sucessor(toRemove.getData()).getData();
			remove(sucessor);
			toRemove.setData(sucessor);
		}
		
	}
	
	private T[] toList(ArrayList<T> lista) {
		
		T[] array = (T[]) new Comparable[this.size()];
		
		for(int i=0; i<lista.size(); i++) {
			array[i] = lista.get(i);
		}
		
		return array;
	}

	@Override
    public T[] preOrder() {      
        ArrayList<T> list = new ArrayList<T>();
        list = preOrder(this.root,list);
        
        return this.toList(list);
    }

    private ArrayList<T> preOrder(BSTNode<T> node, ArrayList<T> list){
    	
    	if(!node.isEmpty()) {
    		list.add(node.getData());
            preOrder((BSTNode<T>)node.getLeft(),list);
            preOrder((BSTNode<T>)node.getRight(),list);
    	}
    	
    	return list;
    }

    @Override
    public T[] order() {
        ArrayList<T> list = new ArrayList<T>();
        list = order(this.root,list);
        
        return this.toList(list);
    }

    private ArrayList<T> order(BSTNode<T> node, ArrayList<T> list){
    	
        if(!node.isEmpty()){
            order((BSTNode<T>) node.getLeft(),list);
            list.add(node.getData());
            order((BSTNode<T>)node.getRight(),list);
        }
        
        return list;
    }

    @Override
    public T[] postOrder() {
        ArrayList<T> list = new ArrayList<T>();
        list = postOrder(this.root,list);
        
        return this.toList(list);
    }

    private ArrayList<T> postOrder(BSTNode<T> node, ArrayList<T> list){
    	
        if(!node.isEmpty()){
            list.add(node.getData());
            postOrder((BSTNode<T>) node.getLeft(),list);
            postOrder((BSTNode<T>)node.getRight(),list);
        }
        
        return list;
    }

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
