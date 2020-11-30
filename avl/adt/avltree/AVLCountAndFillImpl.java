package adt.avltree;

import java.util.*;

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
		if(array == null || array.length == 0) return;

		Arrays.sort(array);
		Map<Integer, List<T>> levels = new TreeMap<>();

		auxFillWithoutRebalance(levels, 0, array.length - 1, 0, array);

		for (Integer key : levels.keySet()) {
			levels.get(key).forEach(t -> super.insert(t));
		}
	}

	private void auxFillWithoutRebalance(Map<Integer, List<T>> map, int leftIndex,
										 int rightIndex, int level, T[] array) {
		if(leftIndex > rightIndex) return;

		int mid = (leftIndex + rightIndex) / 2;
		
		if (!map.containsKey(level)) {
			map.put(level, new ArrayList<>());
			map.get(level).add(array[mid]);
		} else {
			map.get(level).add(array[mid]);
		}

		auxFillWithoutRebalance(map, leftIndex, mid - 1, level + 1, array);
		auxFillWithoutRebalance(map, mid + 1, rightIndex, level + 1, array);
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = super.calculateBalance(node);

		if (balance > 1) {
			this.hangingLeft(node);
		} else if (balance < -1) {
			this.hangingRight(node);
		}
	}

	private void hangingLeft(BSTNode<T> node) {
		BSTNode<T> temp;

		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			// Caso LL
			temp = Util.rightRotation(node);
			this.LLcounter++;
		} else {
			// Caso LR
			Util.leftRotation((BSTNode<T>) node.getLeft());
			temp = Util.rightRotation(node);
			this.LRcounter++;
		}

		if (temp.getParent() == null) {
			super.root = temp;
		}
	}

	private void hangingRight(BSTNode<T> node) {
		BSTNode<T> temp;

		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			// Caso RR
			temp = Util.leftRotation(node);
			this.RRcounter++;
		} else {
			// Caso RL
			Util.rightRotation((BSTNode<T>) node.getRight());
			temp = Util.leftRotation(node);
			this.RLcounter++;
		}

		if (temp.getParent() == null) {
			super.root = temp;
		}
	}

}
