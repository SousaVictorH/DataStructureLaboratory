package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.
	
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
			this.rebalance(node);		
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
				this.rebalanceUp(toRemove);
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
			this.rebalanceUp(toRemove);
			
		} else {
			T sucessor = sucessor(toRemove.getData()).getData();
			remove(sucessor);
			toRemove.setData(sucessor);
		}
		
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int balance = 0;
		
		if(!node.isEmpty()) {
			balance = height(node.getLeft()) - height(node.getRight());
		}
		
		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(root);
		
		if(balance > 1) {
			this.heavierLeft(node);
		} else if(balance < -1) {
			this.heavierRight(node);
		}
	}

	private void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;
		
		if(this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			// LL
			aux = Util.rightRotation(node);
		} else {
			// LR
			Util.leftRotation((BSTNode<T>) (node.getLeft()));
			aux = Util.rightRotation(node);
		}
		
		if(aux.getParent() == null) {
			super.root = aux;
		}
	}

	private void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			// RR
			aux = Util.leftRotation(node);
		} else {
			// RL
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}
	
	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
}
