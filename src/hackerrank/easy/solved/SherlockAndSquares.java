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
public class SherlockAndSquares {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
//            int count = 0;
//            for (; a <= b; a++) {
//                if ((Math.sqrt(a) + "").endsWith(".0")) {
//                    count++;
//                }
//            }
            System.out.println((int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1));
        }

    }
}
