/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLRS.incremental_approach;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorts integer array using selection sort algorithm.
 * Best case time complexity is O(n-1(n-1))=O(n^2).Worst case time complexity is
 * O(n-1(n-1)) = O(n^2)
 * <p>
 * You can modify any algorithm to have a best case time complexity of O(n) by
 * adding a special case, that if the input matches this special case - return a
 * cached hard coded answer (or some other easily obtained answer).
 *
 * For example, for any sort, you can make best case O(n) by checking if the
 * array is already sorted - and if it is, return it as it is.
 *
 * Note it does not impact average or worst cases (assuming they are not better
 * then O(n)), and you basically improve the algorithm's best case time
 * complexity.</p>
 *
 * @author Poonawala
 */
public class SelectionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        selectionSortAscending(new int[]{31, 41, 59, 26, 41, 58});
        selectionSortDescending(new int[]{31, 41, 59, 26, 41, 58});
    }

    /**
     * Prints every step in selection sort and then the sorted array in
     * ascending(increasing) order
     *
     * @param array to sort
     */
    private static void selectionSortAscending(int[] array) {
        int minIndex = 0;
        //from oth index to n-1 index as nth element will anyways be in place because of the exchange at n-1th position
        for (int index = 0; index < array.length - 1; index++) {
            for (int subindex = index + 1; subindex < array.length; subindex++) {
                if (array[subindex] < array[minIndex]) {
                    minIndex = subindex;
                }
            }
            int temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
            Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
            System.out.println("");
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }

    /**
     * Prints every step in selection sort and then the sorted array in
     * descending(non-increasing) order
     *
     * @param array to sort
     */
    private static void selectionSortDescending(int[] array) {
        int minIndex = 0;
        //from oth index to n-1 index as nth element will anyways be in place because of the exchange at n-1th position
        for (int index = 0; index < array.length - 1; index++) {
            for (int subindex = index + 1; subindex < array.length; subindex++) {
                if (array[subindex] > array[minIndex]) {
                    minIndex = subindex;
                }
            }
            int temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
            Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
            System.out.println("");
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }
}
