/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.thirtydaysofcode.solved;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class LetsReview {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        String toPrint = "";
        TestCase:
        for (int i = 1; i <= testcases; i++) {
            String input = in.next();
            StringBuilder evenString = new StringBuilder();
            StringBuilder oddString = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (j % 2 == 0) {
                    evenString.append(input.charAt(j));
                } else {
                    oddString.append(input.charAt(j));
                }
            }
            toPrint += evenString.toString() + " " + oddString.toString()+"\n";
        }
        System.out.println(toPrint);
    }

}
