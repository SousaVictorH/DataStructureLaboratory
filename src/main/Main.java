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
		
		Integer[] lista = {14, 64, 75, 4, 23, 0, 12, 5, 9, 3};
		
		System.out.println(kLargest.orderStatistics(lista, 1));
		System.out.println(kLargest.orderStatistics(lista, 2));
		System.out.println(kLargest.orderStatistics(lista, 3));
		System.out.println("");
		System.out.println(kLargest.orderStatistics(lista, 4));
		System.out.println(kLargest.orderStatistics(lista, 5));
		System.out.println(kLargest.orderStatistics(lista, 6));
		System.out.println("");
		System.out.println(kLargest.orderStatistics(lista, 7));
		System.out.println(kLargest.orderStatistics(lista, 8));
		System.out.println(kLargest.orderStatistics(lista, 9));
	}

}