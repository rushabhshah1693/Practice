/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class FindDigits {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int original = in.nextInt();
            int n = original;
            int count = 0;
            while (n > 0) {
                if (((n % 10) != 0) && (original % (n % 10)) == 0) {
                    count++;
                }
                n = n / 10;
            }
            System.out.println(count);
        }
    }
}
