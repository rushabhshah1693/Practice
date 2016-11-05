/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openbracket;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String toPrint = "";
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            long m = in.nextLong();
            long[] skip = new long[n];
            long sum = 0;
            for (int loop = 0; loop < n; loop++) {
                skip[loop] = in.nextLong();
            }
            for (long j = 1; j <= m; j++) {
                if (includeInSum(j, skip)) {
                    sum += ((Math.pow(j, k)) % (Math.pow(10, 9) + 7));
                }
            }
            System.out.println(sum);
            toPrint += sum + "\n";
        }
        System.out.println(toPrint);
    }

    private static boolean includeInSum(long num, long[] skipList) {
        for (long divisor : skipList) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
