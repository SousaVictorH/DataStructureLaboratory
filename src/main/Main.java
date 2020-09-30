package main;

import java.util.Arrays;

import bubbleSort.*;
import insertionSort.*;
import mergeSort.*;
import quickSort.*;
import selectionSort.*;

public class Main {

	public static void main(String[] args) {
		
		QuickSortMedianOfThree merge = new QuickSortMedianOfThree();
		
		Comparable[] array1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		Comparable[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Comparable[] array3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1};
		Comparable[] array4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		Comparable[] array5 = {12, 45, 7, 6, 445, 97, 2, 356, 87, 34, 23, 54, 101, 45, 22, 77, 66};
		Comparable[] array6 = {12, 45, 7, 6, 445, 97, 2, 356, 87, 34, 23, 54, 101, 45, 22, 77};
		
		Comparable[] array7 = {1, 1, 1, 1, 1, 1};
		Comparable[] array8 = {1};
		
		Comparable[] array9 = {};
		Comparable[] array10 = {"     ", "    ", "   ", "  ", " ", ""};
		
		merge.sort(array1, 0, array1.length-1);
		merge.sort(array2, 0, array2.length-1);
		merge.sort(array3, 0, array3.length-1);
		merge.sort(array4, 0, array4.length-1);
		merge.sort(array5, 0, array5.length-1);
		
		merge.sort(array6, 0, array6.length-1);
		merge.sort(array7, 0, array7.length-1);
		merge.sort(array8, 0, array8.length-1);
		merge.sort(array9, 0, array9.length-1);	
		merge.sort(array10, 0, array10.length-1);
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		System.out.println(Arrays.toString(array4));
		System.out.println(Arrays.toString(array5));
		System.out.println(Arrays.toString(array6));
		System.out.println(Arrays.toString(array7));
		System.out.println(Arrays.toString(array8));
		System.out.println(Arrays.toString(array9));
		System.out.println(Arrays.toString(array10));
	}

}
