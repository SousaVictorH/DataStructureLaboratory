package adt.avltree;

import java.awt.List;
import java.util.Map;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if(array!=null) {
			
		}
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = super.calculateBalance(node);

		if (balance > 1) {
			this.heavierLeft(node);
		} else if (balance < -1) {
			this.heavierRight(node);
		}
	}

	private void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			aux = Util.rightRotation(node);
			this.LLcounter++;
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
			this.LRcounter++;
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

	private void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			aux = Util.leftRotation(node);
			this.RRcounter++;
		} else {
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
			this.RLcounter++;
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

}
