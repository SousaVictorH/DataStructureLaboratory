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
		
		Integer[] array1 = {24, -51, 0, 52, 76, -104, -124, -4, 5, 8, -15, 1};
		
		cs.sort(array1, 0, array1.length-1);
		
		System.out.println(Arrays.toString(array1));
	}

}
