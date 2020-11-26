package adt.avltree;

import java.awt.List;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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
		
		Map<Integer, List> levels = new TreeMap<>();
		
		auxFillWithoutRebalance(levels, 0, array.length-1, 0, array);
		
		for(List list: levels.values()) {
			((Map<Integer, List>) list).forEach((t) -> super.insert(t));
		}
	}

	private void auxFillWithoutRebalance(Map<Integer, List> levels, int i, int j, int k, T[] array) {
		// TODO Auto-generated method stub
		
	}

}
