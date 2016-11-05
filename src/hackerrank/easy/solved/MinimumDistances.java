/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class MinimumDistances {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> NumberIndicesMap = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (NumberIndicesMap.containsKey(arr[i])) {
                int x = NumberIndicesMap.get(arr[i]);
                int dist = i - x;
                if (dist < minDist) {
                    minDist = dist;
                }
            } else {
                NumberIndicesMap.put(arr[i], i);
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }
        System.out.println(minDist);
    }
}
