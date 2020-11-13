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

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException, QueueUnderflowException, QueueOverflowException {
		
		//RecursiveSingleLinkedListImpl l1 = new RecursiveSingleLinkedListImpl();
		BSTImpl arvore = new BSTImpl();
		
		System.out.println(arvore.isEmpty());
		
		System.out.println(arvore.height());
		
		System.out.println(arvore.minimum());
		
		arvore.insert(10);
		
		System.out.println(arvore.minimum());
	}

}