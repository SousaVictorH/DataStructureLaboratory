package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> newRoot = (BSTNode<T>) node.getRight();
		BSTNode<T> leftChild = (BSTNode<T>) newRoot.getLeft();
		BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

		if (parentNode != null) {
			if (parentNode.getLeft().equals(node)) {
				parentNode.setLeft(newRoot);
			} else {
				parentNode.setRight(newRoot);
			}
		}

		newRoot.setParent(parentNode);
		node.setParent(newRoot);
		node.setRight(leftChild);
		newRoot.setLeft(node);

		if (leftChild != null) {
			leftChild.setParent(node);
		}

		return newRoot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> newRoot = (BSTNode<T>) node.getLeft();
		BSTNode<T> rightChild = (BSTNode<T>) newRoot.getRight();
		BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

		if (parentNode != null) {
			if (parentNode.getLeft().equals(node)) {
				parentNode.setLeft(newRoot);
			} else {
				parentNode.setRight(newRoot);
			}
		}

		newRoot.setParent(parentNode);
		node.setParent(newRoot);
		node.setLeft(rightChild);
		newRoot.setRight(node);

		if (rightChild != null) {
			rightChild.setParent(node);
		}

		return newRoot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
