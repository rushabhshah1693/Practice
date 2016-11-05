/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import hackerrank.easy.solved.*;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class JumpingOnTheCloudsRevisited {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int position = 0;
        int energy = 100;
        do {
            position = (position + k) % n;
            energy--;
            if (c[position] == 1) {
                energy -= 2;
            }
        } while (position != 0);
        System.out.println(energy);
    }
}
