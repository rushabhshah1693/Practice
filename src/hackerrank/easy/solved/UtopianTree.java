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
public class UtopianTree {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = in.nextInt();
            int height = 1;
            for (int j = 1; j <= n; j++) {
                if (j % 2 != 0) {
                    height *=2;
                }else{
                    height++;
                }
            }
            System.out.println(height);
        }

    }
}
