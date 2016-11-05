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
public class ChocolateTrips {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int chocolates = n / c;
            int wrappers = n / c;
            while (wrappers >= m) {
                chocolates += wrappers / m;
                int additionalWrappers = wrappers / m;
                wrappers = wrappers - ((wrappers / m) * m);
                wrappers += additionalWrappers;
            }
            System.out.println(chocolates);
        }
    }
}
