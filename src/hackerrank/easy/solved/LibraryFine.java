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
public class LibraryFine {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();

        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int fine=0;
        if (y2 < y1) {
            fine = 10000;
        } else if (y1 == y2) {
            if (m1 > m2) {
                fine = (m1 - m2) * 500;
            } else if (m1 == m2) {
                if (d1 > d2) {
                    fine = (d1 - d2) * 15;
                }
            }
        }
        System.out.println(fine);
    }
}
