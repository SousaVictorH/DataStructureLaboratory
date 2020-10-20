package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;
import adt.stack.*;

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		
		StackImpl stack = new StackImpl(5);
		
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(null);
		
		System.out.println(stack.top());
	}

}