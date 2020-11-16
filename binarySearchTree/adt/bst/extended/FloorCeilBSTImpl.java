package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {		
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		this.fillTree(array, 0, tree);
		
		if(tree.isEmpty()) {
			return null;
		}

		return this.floor(tree.getRoot(), numero);
	}

	private void fillTree (Integer[] array, int index, BSTImpl<Integer> tree){
		if(index >= array.length) return;
		
		tree.insert(array[index]);
		this.fillTree(array, index +1, tree);
	}
	
	private Integer floor(BSTNode<Integer> node, double numero){		
		Integer floor = null;
		
		if(node.isEmpty()){
			return floor;
		}
		
		if(node.getData() == numero){
			
			floor = node.getData();
			
		} else if(node.getData() > numero){
			// procurar na esquerda
			if(!node.getLeft().isEmpty()) {
				floor = floor((BSTNode<Integer>) node.getLeft(),numero);
			}
				
		} else {
			// procurar na direita
			Integer aux = null;
			
			if(!node.getRight().isEmpty()){
				aux = this.floor((BSTNode<Integer>)node.getRight(),numero);
			}
			
			if(aux == null) floor = node.getData();
			else floor = aux;

		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {		
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		this.fillTree(array, 0, tree);
		
		if(tree.isEmpty()) return null;

		return this.ceil(tree.getRoot(), numero);
	}
	
	private Integer ceil(BSTNode<Integer> node, double numero){	
		Integer ceil = null;
		
		if(node.isEmpty()){
			return ceil;
		}
		
		if(node.getData() == numero){
			
			ceil = node.getData();
		
		} else if(node.getData() < numero){
			// procurar na direita
			if(!node.getRight().isEmpty()) {
				ceil = ceil((BSTNode<Integer>) node.getRight(),numero);
			}
			
		} else {
			// procurar na esquerda
			Integer aux = null;
			
			if(!node.getLeft().isEmpty()){
				aux = this.ceil((BSTNode<Integer>)node.getLeft(),numero);
			}
			
			if(aux == null) ceil =  node.getData();
			else ceil = aux;

		}

		return ceil;
	}

}
