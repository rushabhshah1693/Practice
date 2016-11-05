/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLRS.incremental_approach;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorts the given array using insertion sort algorithm. Time complexity of the
 * algorithm is <b>O(n^2)</b>
 * <p>
 * Also, can search linearly for a value in the array.</p>
 *
 * @author Poonawala
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

//        insertSortTheArrayAscending(new int[]{31, 41, 59, 26, 41, 58});
//        insertSortTheArrayDescending(new int[]{31, 41, 59, 26, 41, 58});
//        linearSearch(31, new int[]{31, 41, 59, 26, 41, 58});
//        linearSearch(34, new int[]{31, 41, 59, 26, 41, 58});
//        linearSearch(41, new int[]{31, 41, 59, 26, 41, 58});
//        binarySearch(31, new int[]{31, 41, 59, 26, 41, 58});
//        binarySearch(34, new int[]{31, 41, 59, 26, 41, 58});
//        binarySearch(41, new int[]{31, 41, 59, 26, 41, 58});
        insertSortTheArrayDescendingUsingBinarySearch(new int[]{31, 41, 59, 26, 41, 58});
    }

    /**
     * Prints every step in insertion sort and then the sorted array in
     * ascending(increasing) order
     *
     * @param array to sort
     */
    private static void insertSortTheArrayAscending(int[] array) {

        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i > -1 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
                Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
                System.out.println("");
            }
            array[i + 1] = key;
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }

    /**
     * prints every step in insertion sort and then the sorted array in
     * descending(non-increasing) order
     *
     * @param array to sort
     */
    private static void insertSortTheArrayDescending(int[] array) {

        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i > -1 && array[i] < key) {
                array[i + 1] = array[i];
                i = i - 1;
                Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
                System.out.println("");
            }
            array[i + 1] = key;
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }

    /**
     * Linear search to find the number if present in the array
     *
     * @param number to look for
     * @param array to look into
     */
    private static Integer linearSearch(int number, int[] array) {
        /*loop invariant condition 1
        before the loop executes if array length is < 0 returns null*/
        if (array.length == 0) {
            System.out.println("NULL");
            return null;
        }
        for (int index = 0; index < array.length; index++) {
            /*loop invariant condition 2
            before the loop executes if it is the first or second integer it will return a index*/
            if (number == array[index]) {
                System.out.println(index);
                return index;
            }
        }
        /*loop invariant condition 3
        after the loop terminates it returns null if it hasn't already returned a value*/
        System.out.println("NULL");
        return null;
    }

    /**
     * Binary search to find the number if present in the array
     *
     * @param number to look for
     * @param array sorted array to look into
     */
    public static Integer binarySearch(int number, int[] array) {
        /*loop invariant condition 1
        before the loop executes if array length is < 0 returns null*/
        Arrays.sort(array);
        if (array.length == 0) {
            System.out.println("NULL");
            return null;
        }
        int index = 0;
        int pivot = array.length;
        while (index != 0) {
            /*loop invariant condition 2
            before the loop executes if it is the first or second integer it will return a index*/
            if (number > array[(int) Math.floor((index + pivot) / 2)]) {
                index = (int) Math.floor((index + pivot) / 2);
            } else if (number < array[(index + pivot) / 2]) {
                pivot = (int) Math.floor((index + pivot) / 2);
            } else {
                System.out.println((int) Math.floor((index + pivot) / 2));
                return (int) Math.floor((index + pivot) / 2);
            }
        }
        if (index == 0 && number == array[index]) {
            return index;
        }
        /*loop invariant condition 3
        after the loop terminates it returns null if it hasn't already returned a value*/
        System.out.println("NULL");
        return null;
    }

    /**
     * Binary search to find the number if present in the array
     *
     * @param number to look for
     * @param array sorted array to look into
     */
    private static Integer binarySearchForInsertionSort(int number, int[] array, int startIndex, int endIndex) {
        /*loop invariant condition 1
        before the loop executes if array length is < 0 returns null*/
        if (array.length == 0) {
            System.out.println("NULL");
            return null;
        }
        int index = startIndex;
        int pivot = endIndex;
        boolean flagGt = false, flagLt = false, flagEq = false;
        while ((flagEq) || (flagGt && flagLt)) {
            /*loop invariant condition 2
            before the loop executes if it is the first or second integer it will return a index*/
            if (number > array[(int) Math.ceil((index + pivot) / 2)]) {
                index = (int) Math.ceil((index + pivot) / 2);
                flagGt = true;
            } else if (number < array[(index + pivot) / 2]) {
                pivot = (int) Math.ceil((index + pivot) / 2);
                flagLt = true;
            } else {
                System.out.println((int) Math.ceil((index + pivot) / 2));
                flagEq = true;
            }
        }
        return (int) Math.ceil((index + pivot) / 2);
        /*loop invariant condition 3
        after the loop terminates it returns null if it hasn't already returned a value*/
//        System.out.println("NULL");
//        return null;
    }

    /**
     * prints every step in insertion sort and then the sorted array in
     * descending(non-increasing) order looks for the element position using
     * binary search instead of linear search
     * <p>
     * Hence, the time complexity changes from <b>O(n^2)</b> to
     * <b>O(nlogn)</b></p>
     *
     * @param array to sort
     */
    private static void insertSortTheArrayDescendingUsingBinarySearch(int[] array) {

        int[] sortedArray = new int[array.length];
        for (int j = 0; j < array.length; j++) {
            int key = array[j];
            int index = binarySearchForInsertionSort(key, array, 0, j);
            int i = index;
            sortedArray[i] = key;
            while (i > -1 && array[i] < key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            sortedArray[i + 1] = key;
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }

}
