package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return (bst.isEmpty()) ? true : isBST(bst.getRoot());
	}

	private boolean isBST(BTNode<T> node) {
		if (node.isEmpty()) return true;
		
		if(!node.getLeft().isEmpty()) {
			if(node.getData().compareTo(node.getLeft().getData()) < 0) return false;
		}
		
		if(!node.getRight().isEmpty()) {
			if(node.getData().compareTo(node.getRight().getData()) > 0) return false;
		}
		
		return isBST(node.getRight()) && isBST(node.getLeft());
	}
	
}
