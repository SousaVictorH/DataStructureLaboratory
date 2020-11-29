package adt.bst;

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
		if(bst.size() <= 1) return true;	
		return isBST(this.bst.root);
	}

	private boolean isBST(BSTNode<T> node) {
		if(node.isEmpty()) return true;
		boolean aux;
		
		if(!node.getLeft().isEmpty()) {
			if(node.getData().compareTo(node.getLeft().getData()) < 1) return false;
			else aux = isBST((BSTNode<T>) node.getLeft());
			if(!aux) return false;
		}
		if(!node.getRight().isEmpty()) {
			if(node.getData().compareTo(node.getRight().getData()) > 1) return false;
			else aux = isBST((BSTNode<T>) node.getRight());
			if(!aux) return false;
		}
		
		return true;
	}
	
}
