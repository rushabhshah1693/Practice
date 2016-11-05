/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int loop = 0; loop < N; loop++) {
            int next = in.nextInt();
            array[loop] = next;
            int key = array[loop];
            int i = loop - 1;
            while (i > -1 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }

        int loop = 0;
        int min;
        do {
            min = array[loop++];
            if (min > 0) {
                int loop2 = loop - 1;
                for (; loop2 < N; loop2++) {
                    array[loop2] -= min;
                }
                System.out.println(N - loop + 1);
            }
        } while (loop < N);

    }

}
