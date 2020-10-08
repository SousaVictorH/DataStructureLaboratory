package main;

import java.util.Arrays;

import bubbleSort.*;
import insertionSort.*;
import mergeSort.*;
import quickSort.*;
import selectionSort.*;
import coutingSort.*;

public class Main {

	public static void main(String[] args) {
		
		ExtendedCountingSort cs = new ExtendedCountingSort();
		
		// ARRAY PAR
		
		Integer[] array1 = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0};
		Integer[] array2 = {4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
		Integer[] array3 = {5, 7, -4, 12, -34, 0, 56, -70, 15};
		
		// ARRAY IMPAR
		
		Integer[] array4 = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 99};
		Integer[] array5 = {4, 3, 2, 1, 0, -1, -2, -3, -4, -5, 99};
		Integer[] array6 = {5, 7, -4, 12, -34, 0, 56, -70, 15, -99};
		
		// ARRAY VAZIO, UNITARIO E BINARIO
		
		Integer[] array7 = {};
		Integer[] array8 = {-1};
		Integer[] array9 = {2, -1};
		
		// UTILIZANDO O RIGHT INDEX != ARRAY.LENGHT
		
		Integer[] array10 = {10, -9, 8, -7, -6, -5, 4, 3, 2, 1};
		Integer[] array11 = {10, 9, 8, -7, -6, -5, -4, 3, 2, 1};
		
		// UTILIZANDO O LEFT INDEX != 0
		
		Integer[] array12 = {-10, -9, -8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] array13 = {10, 9, 8, -7, -6, -5, 4, 3, 2, 1};
		
		cs.sort(array1, 0, array1.length-1);
		cs.sort(array2, 0, array2.length-1);
		cs.sort(array3, 0, array3.length-1);
		
		cs.sort(array4, 0, array4.length-1);
		cs.sort(array5, 0, array5.length-1);
		cs.sort(array6, 0, array6.length-1);
		
		cs.sort(array7, 0, array7.length-1);
		cs.sort(array8, 0, array8.length-1);
		cs.sort(array9, 0, array9.length-1);
		
		cs.sort(array10, 0, 5);
		cs.sort(array11, 0, 6);
		
		cs.sort(array12, 5, array12.length-1);
		cs.sort(array13, 6, array13.length-1);
		
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		System.out.println();
		System.out.println(Arrays.toString(array4));
		System.out.println(Arrays.toString(array5));
		System.out.println(Arrays.toString(array6));
		System.out.println();
		System.out.println(Arrays.toString(array7));
		System.out.println(Arrays.toString(array8));
		System.out.println(Arrays.toString(array9));
		System.out.println();
		System.out.println(Arrays.toString(array10));
		System.out.println(Arrays.toString(array11));
		System.out.println();
		System.out.println(Arrays.toString(array12));
		System.out.println(Arrays.toString(array13));
		
		
	}

}
