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
public class FairRations {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int breadGiven = 0;
        int carry = 0;
        int currentNo = 0;
        if (n == 2) {
            System.out.println("NO");
        } else {
            for (int i = 1; i <= n; i++) {
                currentNo = in.nextInt();
                currentNo += carry;
                if (currentNo % 2 != 0) {
                    breadGiven++;
                    breadGiven++;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            if (currentNo % 2 == 0) {
                System.out.println(breadGiven);
            } else {
                System.out.println("NO");
            }
        }
    }
}
