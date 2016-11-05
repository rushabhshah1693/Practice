/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Poonawala
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static ArrayList<Integer> upperQueue;
    static ArrayList<Integer> lowerQueue;

    public static void main(String[] args) {
        lowerQueue = new ArrayList<>();
        upperQueue = new ArrayList<>();
        lowerQueue.add(Integer.MAX_VALUE);
        upperQueue.add(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long d = in.nextLong();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(s);
//        int first = 0, second = 0;
//        float median = 0.0f;
        Random random = new Random();
        Solution runningMedian = new Solution();
        long count = 0;
        for (long i = 1; i <= n; i++) {
            int num = in.nextInt();
            double median = runningMedian.getMedian(num, d);
            if (num >= 2 * median && i > d) {
                count++;
            }

        }
        System.out.println(count);
    }

    public static int selectKth(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            throw new Error();
        }

        int from = 0, to = arr.length - 1;

        // if from == to we reached the kth element
        while (from < to) {
            int r = from, w = to;
            int mid = arr[(r + w) / 2];

            // stop if the reader and writer meets
            while (r < w) {

                if (arr[r] >= mid) { // put the large values at the end
                    int tmp = arr[w];
                    arr[w] = arr[r];
                    arr[r] = tmp;
                    w--;
                } else { // the value is smaller than the pivot, skip
                    r++;
                }
            }

            // if we stepped up (r++) we need to step one down
            if (arr[r] > mid) {
                r--;
            }

            // the r pointer is on the end of the first k elements
            if (k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }

        return arr[k];
    }

    public double getMedian(int num, long d) {
        //adding the number to proper heap
        if (num >= upperQueue.get(0)) {
            upperQueue.add(num);
        } else {
            lowerQueue.add(num);
        }

        //balancing the heaps
        if (upperQueue.size() - lowerQueue.size() == 2) {
            lowerQueue.add(upperQueue.remove(upperQueue.size() - 1));
        } else if (lowerQueue.size() - upperQueue.size() == 2) {
            upperQueue.add(lowerQueue.remove(lowerQueue.size() - 1));
        }

        if (upperQueue.size() + lowerQueue.size() > d) {
            if (upperQueue.size() - lowerQueue.size() >= 1) {
                lowerQueue.add(upperQueue.remove(upperQueue.size() - 1));
            } else if (lowerQueue.size() - upperQueue.size() >= 1) {
                upperQueue.add(lowerQueue.remove(lowerQueue.size() - 1));
            }
        }
        //returning the median

        if (upperQueue.size() == lowerQueue.size()) {
            return (upperQueue.get(0) + lowerQueue.get(0)) / 2.0;
        } else if (upperQueue.size() > lowerQueue.size()) {
            return upperQueue.get(0);
        } else {
            return lowerQueue.get(0);
        }

    }

}
