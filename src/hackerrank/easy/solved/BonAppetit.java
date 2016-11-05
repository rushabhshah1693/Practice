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
public class BonAppetit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long total = 0;
//        long skipped = 0;
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            if (i != k) {
                total += value;
            } 
//            else {
//                skipped = value;
//            }
        }
//        System.out.println("total is "+total);
        long paid = in.nextLong();
        if ((total - paid * 2) == 0) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(Math.abs((((total) - paid * 2) / 2)));
        }

    }
}
