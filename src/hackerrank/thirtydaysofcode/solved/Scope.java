/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.thirtydaysofcode.solved;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class Scope {

    private int[] elements;
    public int maximumDifference;

    Scope(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (maximumDifference < Math.abs(elements[i] - elements[j])) {
                    maximumDifference = Math.abs(elements[i] - elements[j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Scope difference = new Scope(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
