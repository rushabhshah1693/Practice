/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLRS.divide_and_conquer;

import java.util.Arrays;
import java.util.Scanner;
import jdk.nashorn.internal.objects.Global;

/**
 * Sorts the given array using Merge sort algorithm. Time complexity of the
 * algorithm is <b>O(n(logn))</b>
 *
 * @author Poonawala
 */
public class MergeSortInversions {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
        int[] array = new int[]{2, 3, 8, 6, 1};
//                new int[]{2, 4, 5, 7, 1, 2, 3, 6};
        System.out.println(MergeSortAscendingInversions(array, 0, array.length - 1));

//        int[] array2 = new int[]{2, 4, 5, 7, 1, 2, 3, 6};
//        MergeSortDescending(array2, 0, array2.length - 1);
    }

    private static int MergeSortAscendingInversions(int[] array, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            int inversions = 0;
//            System.out.println(""+q);
            inversions += MergeSortAscendingInversions(array, p, q);
            inversions += MergeSortAscendingInversions(array, q + 1, r);
            inversions += mergeTheArrayAscending(array, p, q, r);
            return inversions;
        } else {
            return 0;
        }
    }

    private static void MergeSortDescending(int[] array, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
//            System.out.println(""+q);
            MergeSortDescending(array, p, q);
            MergeSortDescending(array, q + 1, r);
            mergeTheArrayDescending(array, p, q, r);
        }
    }

    /**
     * Prints every step in merge sort and then the sorted array in
     * ascending(increasing) order
     *
     * @param array to sort
     */
    private static int mergeTheArrayAscending(int[] array, int p, int q, int r) {
        //split the array into two parts to merge e.g. like a deck of cards
        int n1 = q - p + 1;//inclusive of q
        int n2 = r - q;
        System.out.println("p is " + p + ", q is " + q + ", r is " + r);
//        System.out.println("called from "+n1+" to "+n2);
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[q + j + 1];
        }
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;
        System.out.println("Left array is:" + Arrays.toString(leftArray));
        System.out.println("Right array is:" + Arrays.toString(rightArray));
        int i = 0, j = 0;
        int inversions = 0;
        for (int k = p; k <= r; k++) {
//            System.out.println("i is" + i);
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i = i + 1;
            } else {
                array[k] = rightArray[j];
                j = j + 1;
                inversions += n1 - i;
            }
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
        return inversions;
    }

    /**
     * prints every step in merge sort and then the sorted array in
     * descending(non-increasing) order without using sentinels(INFINITY at
     * bottom cards)
     *
     * @param array to sort
     */
    private static void mergeTheArrayDescending(int[] array, int p, int q, int r) {
        //split the array into two parts to merge e.g. like a deck of cards
        int n1 = q - p + 1;//inclusive of q
        int n2 = r - q;
        System.out.println("p is " + p + ", q is " + q + ", r is " + r);
//        System.out.println("called from "+n1+" to "+n2);
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[q + j + 1];
        }
        //without using sentinals
//        leftArray[n1] = Integer.MIN_VALUE;
//        rightArray[n2] = Integer.MIN_VALUE;
        System.out.println("Left array is:" + Arrays.toString(leftArray));
        System.out.println("Right array is:" + Arrays.toString(rightArray));
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
//            System.out.println("i is" + i);
            boolean flag = false;
            if (i < n1) {
                if (leftArray[i] >= rightArray[j]) {
                    array[k] = leftArray[i];
                    i = i + 1;
                    flag = true;
                }
            }
            if (!flag && j < n2) {
                array[k] = rightArray[j];
                j = j + 1;
            }
        }
        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }
}
