package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;
import adt.bt.BTNode;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return isBST() && isBalanced(avlTree.getRoot());
	}

	private boolean isBalanced(BTNode<T> node) {
		if (node.isEmpty()) return true;
		int balance = avlTree.calculateBalance(((BSTNode<T>) node));
		
		if(balance > 1 || balance < -1) return false;
		
		return isBalanced(node.getLeft()) && isBalanced(node.getRight());
	}

}
