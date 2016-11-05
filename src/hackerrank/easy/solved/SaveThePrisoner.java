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
public class SaveThePrisoner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String toPrint = "";
        for (int i = 1; i <= testCases; i++) {
            long N = in.nextLong();
            long M = in.nextLong();
            long S = in.nextLong();
            long mod = ((S + M - 1) % N);
            if (M != 1) {
                toPrint += (mod == 0 ? N : mod) + "\n";
            } else {
                toPrint += S + "\n";
            }
        }
        System.out.println(toPrint.substring(0, toPrint.length() - 1));
    }
}
