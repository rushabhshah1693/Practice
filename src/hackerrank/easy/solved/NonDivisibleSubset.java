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
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] mods = new int[k];
        for (int i = 1; i <= n; i++) {
            //sum of two numbers divided by a number is zero iff sum of mods of each number is the divisor
            //having an array of size divisor and setting flag for all remainder values available
            //if the number is k, then sum of k-1 and 1 is k, if flags for k-1 and 1 is set to "1" they are divisible
            long input = in.nextLong();
            mods[(int) (input % k)]++;
        }
        int count = Math.min(mods[0], 1);
        int mid = (int) Math.floor(k / 2);
//        System.out.println(Arrays.toString(mods));
        for (int i = 1; i <= mid; i++) {
//            if ((i == mid) && k % 2 == 0) {
//                count += (mods[i] / 2);
//                continue;
//            } else if ((i == mid) && k % 2 != 0 && ) {
//                count += (mods[i]);
//                continue;
//
//            }
            if (i != k - i) {
//                if (mods[i] >= 1 && mods[k - i] >= 1) {
//                    System.out.println(Math.max(mods[i], mods[k - i]));
                    count += Math.max(mods[i], mods[k - i]);
//                }
            }
        }
        if (k % 2 == 0) {
            count++;
        }
        System.out.println(count);

    }
}
