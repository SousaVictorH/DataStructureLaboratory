package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;

public class Main {

	public static void main(String[] args) {
		
		KLargestOrderStatisticsImpl kL = new KLargestOrderStatisticsImpl();
		
		Integer[] lista = {9, 10, 2, 8, 3, 1, 4, 6, 5, 0};
		
		System.out.println(Arrays.toString(kL.getKLargest(lista, 11)));
		
	}

}