/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string1 = in.next();
        String string2 = in.next();
        System.out.println(Math.abs(string1.length()-string2.length()));
        char[] temp = (string1 + string2).toCharArray();
        MergeSortAscending(temp, 0, temp.length - 1);
//        System.out.println(Arrays.toString(temp));
        char previous = '\u0000';
        int count = 1;
        int deletions = 0;
        for (char currentValue : temp) {
            if (previous == '\u0000') {
                previous = currentValue;
            } else if (currentValue == previous) {
                count++;
                previous = currentValue;
            } else if (currentValue != previous) {
                if (count % 2 != 0) {
                    if (count < 2) {
                        deletions += count;
                    } else {
                        deletions += count / 2;
                    }
                }
                previous = currentValue;
                count = 1;
            }
        }
        if (temp[temp.length - 2] != temp[temp.length - 1]) {
            deletions++;
        }
        System.out.println(deletions);
    }

    private static void MergeSortAscending(char[] array, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
//            System.out.println(""+q);
            MergeSortAscending(array, p, q);
            MergeSortAscending(array, q + 1, r);
            mergeTheArrayAscending(array, p, q, r);
        }
    }

    private static void mergeTheArrayAscending(char[] array, int p, int q, int r) {
        //split the array into two parts to merge e.g. like a deck of cards
        int n1 = q - p + 1;//inclusive of q
        int n2 = r - q;
//        System.out.println("p is " + p + ", q is " + q + ", r is " + r);
//        System.out.println("called from "+n1+" to "+n2);
        char[] leftArray = new char[n1 + 1];
        char[] rightArray = new char[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[q + j + 1];
        }
        leftArray[n1] = Character.MAX_VALUE;
        rightArray[n2] = Character.MAX_VALUE;
//        System.out.println("Left array is:" + Arrays.toString(leftArray));
//        System.out.println("Right array is:" + Arrays.toString(rightArray));
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
//            System.out.println("i is" + i);
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i = i + 1;
            } else {
                array[k] = rightArray[j];
                j = j + 1;
            }
        }
    }
}
