package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;
import adt.queue.*;
import adt.stack.*;

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException, QueueUnderflowException, QueueOverflowException {
		
		QueueUsingStack q1 = new QueueUsingStack(1);
		
		System.out.println(q1.isEmpty());
		
		q1.enqueue(5);
		
		System.out.println(q1.isFull());

	}

}