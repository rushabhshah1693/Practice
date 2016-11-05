/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.weekOfCode25;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class BetweenTwoSets {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int maxA = 0;
        int minB = 101;
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            if (maxA < a[a_i]) {
                maxA = a[a_i];
            }
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
            if (minB > b[b_i]) {
                minB = b[b_i];
            }
        }

        int count = 0;
        for (int i = maxA; i <= minB; i++) {
            if (isAaFactor(a, i) && isXaFactor(b, i)) {
                count++;
            }
        }
        
        System.out.println(count);
    }

    private static boolean isAaFactor(int[] a, int b) {
        for (int temp : a) {
            if (b % temp != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isXaFactor(int[] b, int a) {
        for (int temp : b) {
            if (temp % a != 0) {
                return false;
            }
        }
        return true;
    }
}
