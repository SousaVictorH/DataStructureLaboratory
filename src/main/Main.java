package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;

public class Main {

	public static void main(String[] args) {
		
		FloorBinarySearchImpl kL = new FloorBinarySearchImpl();
		
		Integer[] lista = {9, 10, 2, 8, 3, 1, 4, 6, 5, 0};
		
		System.out.println(kL.floor(lista, -1));
		System.out.println(kL.floor(lista, 0));
		System.out.println(kL.floor(lista, 1));
		System.out.println("");
		System.out.println(kL.floor(lista, 6));
		System.out.println(kL.floor(lista, 7));
		System.out.println(kL.floor(lista, 8));
		System.out.println("");
		System.out.println(kL.floor(lista, 10));
		System.out.println(kL.floor(lista, 11));
		
	}

}