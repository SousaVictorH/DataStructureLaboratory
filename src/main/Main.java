package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;

public class Main {

	public static void main(String[] args) {
		
		FloorBinarySearchImpl bb = new FloorBinarySearchImpl();
		
		Integer[] lista = {1, 2, 3, 4, 6, 7, 8, 9, 10};
		
		System.out.println(bb.floor(lista, 0));
		System.out.println(bb.floor(lista, 1));
		System.out.println(bb.floor(lista, 2));
		System.out.println(bb.floor(lista, 3));
		
		System.out.println(bb.floor(lista, 4));
		System.out.println(bb.floor(lista, 5));
		System.out.println(bb.floor(lista, 6));
		System.out.println(bb.floor(lista, 10));
		System.out.println(bb.floor(lista, 11));
	}

}