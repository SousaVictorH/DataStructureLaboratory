package main;

import java.util.Arrays;

import dividireConquistar.*;
import sortsPadroes.*;
import sortsRecursivos.*;
import buscaBinaria.*;
import estatisticaDeOrdem.*;

public class Main {

	public static void main(String[] args) {
		
		KLargestOrderStatisticsImpl kLargest = new KLargestOrderStatisticsImpl();
		
		Integer[] lista = {10, 9, 2, 8, 3, 7, 1,  4, 6, 5, 0};
		
		System.out.println(Arrays.toString(kLargest.getKLargest(lista, 1)));
		
	}

}