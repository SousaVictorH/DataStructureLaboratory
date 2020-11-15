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
		FloorCeilBSTImpl arvore2 = new FloorCeilBSTImpl();
		
		SimpleBSTManipulationImpl comparator = new SimpleBSTManipulationImpl();
		
	 	System.out.println(comparator.equals(arvore, arvore2));
	 	System.out.println(comparator.isSimilar(arvore, arvore2));
	 	
	 	arvore.insert(10);	 	
	 	arvore2.insert(7);
	 	
//	 	arvore.insert(5);
//	 	arvore2.insert(6);
	 	
	 	System.out.println(comparator.equals(arvore, arvore2));
	 	System.out.println(comparator.isSimilar(arvore, arvore2));
	}

}