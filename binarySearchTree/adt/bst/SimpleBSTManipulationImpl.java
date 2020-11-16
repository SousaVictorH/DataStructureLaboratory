package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {	
		if(tree1.isEmpty() && tree2.isEmpty()) return true;
		
		if(tree1.size() != tree2.size()) return false;
		
		return equals(tree1.getRoot(), tree2.getRoot());
		
	}
	
	private boolean equals(BTNode<T> node1, BTNode<T> node2) {	
		boolean equal = node1.equals(node2);
		
		if(equal) {
			
			if(!node1.getLeft().isEmpty() && !node2.getLeft().isEmpty()) {
				equal = equals(node1.getLeft(), node2.getLeft());
			}else if(node1.getLeft().isEmpty() != node2.getLeft().isEmpty()) {
				equal = false;
			}
			
			if(!equal) return false;
			
			if(!node1.getRight().isEmpty() && !node2.getRight().isEmpty()) {
				equal = equals(node1.getRight(), node2.getRight());
			}else if(node1.getRight().isEmpty() != node2.getRight().isEmpty()) {
				equal = false;
			}
		}
		
		return equal;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		
		if(tree1.isEmpty() && tree2.isEmpty()) return true;
		
		if(tree1.size() != tree2.size()) return false;
		
		return isSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> node1, BTNode<T> node2) {		
		boolean isSimilar = node1.isLeaf() && node2.isLeaf();

		if (!isSimilar) {
			
			if ((!node1.getLeft().isEmpty() && !node2.getLeft().isEmpty())) {
				isSimilar = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			} else if (node1.getLeft().isEmpty() && node2.getLeft().isEmpty()) {
				isSimilar = true;
			}
			
			if(!isSimilar) {
				return false;
			}

			if (!node1.getRight().isEmpty() && !node2.getRight().isEmpty()) {
				isSimilar = isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			} else if (node1.getRight().isEmpty() && node2.getRight().isEmpty()) {
				isSimilar = true;
			}
			
		}
		
		return isSimilar;		
	}


	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T toReturn = null;
		
		if(k >= 1 && k <= tree.size()) {
			toReturn = orderStatistic(tree, tree.minimum(), k-1);
		}
		
		return toReturn;
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k) {
		
		if(k == 0) {
			return node.getData();
		}else {
			return orderStatistic(tree, tree.sucessor(node.getData()), k-1);
		}
		
	}

}
