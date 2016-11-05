/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.weekOfCode25;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class AppendAndNext {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        int sIterator = 0;
        int minNonMatchingIndex = -1;
        if (!s.equalsIgnoreCase(t)) {
            for (; sIterator < s.length(); sIterator++) {
                if (sIterator < t.length()) {
                    if (s.charAt(sIterator) != t.charAt(sIterator)) {
                        minNonMatchingIndex = sIterator;
                        break;
                    }
                } else {
                    minNonMatchingIndex = ++sIterator;
                    break;
                }
            }
            int deletions = 0;
            if (minNonMatchingIndex != -1) {
                    deletions = s.length() - (minNonMatchingIndex);
            }
            int insertions = 0;

            if (deletions == 0) {
                if (s.length() < t.length()) {
                    insertions = t.length() - s.length();
                }//S > T and deletions=0 not possible
                //S = T means Strings are equal already handled
            } else if (deletions != 0) {
                if (s.length() < t.length()) {
//                    insertions = t.length() - s.length() + (t.length() - minNonMatchingIndex) - 1;
                    insertions = t.length() - s.length() + (s.length() - minNonMatchingIndex);
                } else if (s.length() > t.length()) {//for s>=t
                    insertions = t.length() - minNonMatchingIndex;
                }else {
//                    insertions = 0;
                    insertions = t.length() - minNonMatchingIndex;
                }
            }

//            if (minNonMatchingIndex != -1 && s.length() >= t.length()) {
//                insertions = t.length() - (minNonMatchingIndex);
//            } else if (minNonMatchingIndex == -1 && s.length() < t.length()) {
//                insertions = t.length() - s.length();
//            }
            int minimumStepsRequired = deletions + insertions;

//            System.out.println("Minimum Steps Required:" + minimumStepsRequired);
            if (minimumStepsRequired == k) {
                System.out.println("Yes");
            }
            
            
            else if (minimumStepsRequired < k) {
                if ((k - minimumStepsRequired) % 2 == 0 && k >= 2) {//playing with single element deleting and adding it to match k
                    System.out.println("Yes");
                }
                
                
                else if (minNonMatchingIndex != -1 && (k - (minimumStepsRequired + minNonMatchingIndex * 2) >= 0)) {//removing all elements and playing with empty string to match k
                    System.out.println("Yes");
                } 
                
//                else if ((minNonMatchingIndex == -1 && (k - (minimumStepsRequired) >= 0))) {
//                    System.out.println("Yes");
//                }
                else {
                    System.out.println("No");
                }
            }
            
            
            
            
            else if (minimumStepsRequired > k) {
//            if (s.equalsIgnoreCase(t)) {
//                System.out.println("Yes");
//            } else {
                System.out.println("No");
//            }
            }
        } else if (k % 2 == 0) {
            System.out.println("Yes");
        } else if ((k - (s.length() * 2) >= 0)) {//removing all elements and playing with empty string to match k
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
