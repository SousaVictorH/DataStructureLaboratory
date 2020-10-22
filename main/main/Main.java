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
		
		QueueUsingStack q1 = new QueueUsingStack(5);
		QueueImpl q2 = new QueueImpl(5);
		
		System.out.println(q1.head());
		System.out.println(q2.head());
		
		q1.enqueue(1);
		q2.enqueue(1);
		
		q1.enqueue(2);
		q2.enqueue(2);
		
		q1.enqueue(3);
		q2.enqueue(3);
		
		q1.enqueue(4);
		q2.enqueue(4);
		
		q1.enqueue(5);
		q2.enqueue(5);
		
		System.out.println(q1.dequeue());
		System.out.println(q2.dequeue());
		
		System.out.println(q1.dequeue());
		System.out.println(q2.dequeue());
		
		System.out.println(q1.head());
		System.out.println(q2.head());

	}

}