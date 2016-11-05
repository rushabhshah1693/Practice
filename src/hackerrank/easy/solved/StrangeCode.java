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
public class StrangeCode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long time = in.nextLong();
        int n = 0;
        long timeSkipped = 0;
        while (time > timeSkipped) {
            time -= (Math.pow(2, (n)) * 3);
            timeSkipped = (long) (Math.pow(2, (n + 1)) * 3);
            n++;
        }
//        System.out.println("n is" + n);
//        System.out.println("time skipped" + timeSkipped);
        if (time > 0) {
            System.out.println((long) (Math.pow(2, n) * 3) - time + 1);
        } else {
            System.out.println((long) (Math.pow(2, n) * 3) + time - 1);
        }
    }
}
