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
	}

}