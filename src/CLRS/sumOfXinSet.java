package CLRS;

import CLRS.incremental_approach.InsertionSort;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Poonawala
 */
public class sumOfXinSet {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 7, 1, 2, 3, 6};
        int x = 2;
        for (int j = 1; j < array.length; j++) {
            if (InsertionSort.binarySearch(x - array[j], array) != null) {//check for start index remaining
                System.out.println("Exists");
                break;
            }
        }
    }

}
