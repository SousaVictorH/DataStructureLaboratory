package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;
import adt.linkedList.*;
import adt.queue.*;
import adt.stack.*;
import adt.bst.*;
import adt.bst.extended.*;

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException, QueueUnderflowException, QueueOverflowException {
		
		//RecursiveSingleLinkedListImpl l1 = new RecursiveSingleLinkedListImpl();
		FloorCeilBSTImpl arvore = new FloorCeilBSTImpl();
		
		arvore.insert(10);
		
		System.out.println(Arrays.toString(arvore.order()));
		
		arvore.insert(10);
		
		System.out.println(Arrays.toString(arvore.order()));
	}

}