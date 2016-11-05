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
public class TwoDArrays {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum;
        for (int row = 1; row < 5; row++) {
            for (int column = 1; column < 5; column++) {
                currentSum = arr[row][column] + arr[row - 1][column] + arr[row + 1][column] + arr[row - 1][column - 1] + arr[row + 1][column - 1] + arr[row - 1][column + 1] + arr[row + 1][column + 1];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
        }

        System.out.println(maxSum);
    }
}
