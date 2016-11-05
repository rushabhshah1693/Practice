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
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        String toPrint = "";
        TestCase:
        for (int i = 1; i <= testcases; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int count = 0;
            for (int student = 1; student <= N; student++) {
                if (in.nextInt() >= 0) {
                    count++;
                }
            }
            if (count >= K) {
                toPrint = "NO\n";
            } else {
                toPrint = "YES\n";
            }
        }
        System.out.println(toPrint);
    }
}
