package assignment1;

import java.util.Arrays;

public class Lab1Sorting {
    /**
     * This is the skeleton code for the sorting algorithms implementations for
     * Assignment 1. The methods that are currently not implemented throw the
     * UnsupportedOperationException. You may add more methods to the class, but
     * please do not change the names or types of the existing methods.
     */

    // Insertion sort.

    public static void insertionSort(int[] array) {

	for (int i = 1; i < array.length; i++) {

	    int value = array[i];
	    int j = i - 1;

	    while (j >= 0 && array[j] > value) {

		array[j + 1] = array[j];
		j = j - 1;

	    }
	    array[j + 1] = value;
	}
    }

    // Quicksort.

    public static void quickSort(int[] array) {
	quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
	// Base case.
	if (begin >= end)
	    return;

	// Partition the array.
	int pivot = partition(array, begin, end);

	// Now recursively quicksort the two partitions.
	quickSort(array, begin, pivot - 1);
	quickSort(array, pivot + 1, end);
	// throw new UnsupportedOperationException();
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
	// array[begin] will be the pivot element
	int low = begin + 1;
	int high = end;
	int pivot = array[begin];
	int inc = begin;

	for (int i = low; i <= high; i++) {
	    if (array[i] <= pivot) {
		inc++;
		swap(array, i, inc);
	    }
	}
	swap(array, inc, begin);
	return inc;

	// throw new UnsupportedOperationException();

    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
	int x = array[i];
	array[i] = array[j];
	array[j] = x;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
	return mergeSort(array, 0, array.length - 1);
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
	// Base case: array of length 0 or 1.
	if (begin > end)
	    return new int[0];
	if (begin == end) {
	    int[] result = { array[begin] };
	    return result;
	}

	// Midpoint of the array
	int mid = (begin + end) / 2;
	
	// Recursively sort both halves of the array,
	int[] arrayLeft = new int[array.length/2];
	int[] arrayRight = new int[array.length/2];
	arrayLeft = mergeSort(array,begin,mid);
	arrayRight = mergeSort(array,mid+1,end);
	// then merge the results.

	return merge(arrayLeft,arrayRight);
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
	// The result array
	int[] result = new int[left.length + right.length];
	// How far we have got in the result array
	int nextResult = 0;
	// How far we have got in the left array
	int nextLeft = 0;
	// How far we have got in the right array
	int nextRight = 0;

	// Idea: repeatedly copy one element from either the left or right array to the
	while(nextLeft < left.length && nextRight < right.length) {
		if(left[nextLeft] < right[nextRight]) {
			result[nextResult] = left[nextLeft];
			nextLeft++;
		}else {
			result[nextResult] = right[nextRight];
			nextRight++;
		}
		nextResult++;
	}
	while(nextLeft < left.length) {
		result[nextResult] = left[nextLeft];
		nextLeft++;
		nextResult++;
	}
	while(nextRight < right.length) {
		result[nextResult] = right[nextRight];
		nextRight++;
		nextResult++;
	}
	// result array.
	return result;
    }

    public static void main(String[] args) {
	// Put code here to try out your algorithms
	int[] example1 = new int[] { 3, 5, 6, 4, 2, 1 };
	// Insertion sort performs sorting in place, and it will
	// modify the original array;
	//System.out.println(Arrays.toString(mergeSort(example1)));
	//System.out.println(Arrays.toString(example1));
	// System.out.println(Arrays.toString(example1));
	// quickSort(example1, 0, example1.length - 1);
	// System.out.println(Arrays.toString(example1));
    }
}
