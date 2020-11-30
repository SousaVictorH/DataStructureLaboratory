package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> rightNode = (BSTNode<T>) node.getRight();
		BSTNode<T> leftNode = (BSTNode<T>) rightNode.getLeft();
		BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

		if (parentNode != null) {
			if (parentNode.getLeft().equals(node)) {
				parentNode.setLeft(rightNode);
			} else {
				parentNode.setRight(rightNode);
			}
		}

		rightNode.setParent(parentNode);
		rightNode.setLeft(node);
		node.setParent(rightNode);
		node.setRight(leftNode);

		if (!leftNode.isEmpty()) {
			leftNode.setParent(node);
		}

		return rightNode;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
		BSTNode<T> rightNode = (BSTNode<T>) leftNode.getRight();
		BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

		if (parentNode != null) {
			if (parentNode.getLeft().equals(node)) {
				parentNode.setLeft(leftNode);
			} else {
				parentNode.setRight(leftNode);
			}
		}

		leftNode.setParent(parentNode);
		leftNode.setRight(node);
		node.setParent(leftNode);
		node.setLeft(rightNode);

		if (!rightNode.isEmpty()) {
			rightNode.setParent(node);
		}

		return leftNode;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
