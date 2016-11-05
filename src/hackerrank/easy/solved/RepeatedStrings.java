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
public class RepeatedStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long occurences = 0;
        long extraLengthOfStringIncluded = n % s.length();
        long noOfCompleteStringIncluded = n / s.length();
        long countSingle = 0;
        for (int i = 0; i < s.length(); i++) {
            //n/s is the number of times the string is repeated completely so it the character 'a' will be repeated atleast that many
            //times for each occurence in the input string
            //also n%s is the number of extra characters in the length n i.e incomplete length of input string
            //if the occurence position <= n%s then count+1 for that occurence
            if (s.charAt(i) == 'a') {
                occurences++;
                if (i < extraLengthOfStringIncluded) {
                    countSingle++;
                }
            }
        }
        System.out.println((occurences*noOfCompleteStringIncluded)+countSingle);

    }
}
