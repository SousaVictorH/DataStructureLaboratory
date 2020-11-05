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

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException, QueueUnderflowException, QueueOverflowException {
		
		//RecursiveSingleLinkedListImpl l1 = new RecursiveSingleLinkedListImpl();
		RecursiveDoubleLinkedListImpl l1 = new RecursiveDoubleLinkedListImpl();
		
		System.out.println(l1.size());
		
		l1.removeFirst();
		l1.removeLast();
		l1.remove(1);
		
		System.out.println(l1.isEmpty());
		
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		l1.insert(8);
		l1.insert(9);
		l1.insert(10);
		
		System.out.println(l1.isEmpty());
		
		System.out.println(Arrays.toString(l1.toArray()));
		
		l1.removeLast();
		l1.removeLast();
		l1.removeLast();
		l1.removeLast();
		l1.removeLast();
		l1.removeLast();
		l1.removeLast();
		
		System.out.println(Arrays.toString(l1.toArray()));
	}

}