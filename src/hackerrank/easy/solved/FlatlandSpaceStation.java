/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class FlatlandSpaceStation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//no of cities
        int m = in.nextInt();//no of cities with space station
        int[] cityIndexesWithSpaceStation = new int[m];

        int previousIndex = 0;
        int maxDistance = 0;
        for (int i = 0; i < m; i++) {
            cityIndexesWithSpaceStation[i] = in.nextInt();

        }
        MergeSortAscending(cityIndexesWithSpaceStation, 0, cityIndexesWithSpaceStation.length - 1);
        System.out.println(Arrays.toString(cityIndexesWithSpaceStation));
        if (cityIndexesWithSpaceStation[0] != 0) {
            maxDistance = Math.max(Math.abs(cityIndexesWithSpaceStation[0]), maxDistance);
        }
        for (int i = 0; i < m; i++) {
            double currentMid = (previousIndex + cityIndexesWithSpaceStation[i]) / 2.0d;
            int currentDistance;
            if (cityIndexesWithSpaceStation[i] - previousIndex > 1) {
                System.out.println("Mid is "+currentMid);
                currentDistance = (int) Math.floor(Math.max(Math.abs(previousIndex - currentMid), Math.abs(cityIndexesWithSpaceStation[i] - currentMid)));
            } else {
                currentDistance = 0;
            }
            maxDistance = Math.max(currentDistance, maxDistance);
            previousIndex = cityIndexesWithSpaceStation[i];

        }
        if (cityIndexesWithSpaceStation[m - 1] != n - 1) {
            maxDistance = Math.max(Math.abs(previousIndex - (n - 1)), maxDistance);
        }
        System.out.println(maxDistance);
    }

    private static void MergeSortAscending(int[] array, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
//            System.out.println(""+q);
            MergeSortAscending(array, p, q);
            MergeSortAscending(array, q + 1, r);
            mergeTheArrayAscending(array, p, q, r);
        }
    }

    private static void mergeTheArrayAscending(int[] array, int first, int mid, int last) {
        //split the array into two parts to merge e.g. like a deck of cards
        int n1 = mid - first + 1;//inclusive of q
        int n2 = last - mid;
//        System.out.println("p is " + first + ", q is " + mid + ", r is " + last);
//        System.out.println("called from "+n1+" to "+n2);
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[first + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + j + 1];
        }
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;
//        System.out.println("Left array is:" + Arrays.toString(leftArray));
//        System.out.println("Right array is:" + Arrays.toString(rightArray));
        int i = 0, j = 0;
        for (int k = first; k <= last; k++) {
//            System.out.println("i is" + i);
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i = i + 1;
            } else {
                array[k] = rightArray[j];
                j = j + 1;
            }
        }
//        Arrays.stream(array).forEach((a) -> System.out.print(a + " "));
    }
}
