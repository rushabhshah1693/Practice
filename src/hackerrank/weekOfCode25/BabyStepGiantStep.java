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
public class BabyStepGiantStep {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int queries = 1; queries <= q; queries++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int d = in.nextInt();
            int distanceCovered = 0;
            int steps = 0;
            while (true) {
                if (distanceCovered == d) {
                    if (d == 0) {
                        System.out.println("0");
                    } else {
                        System.out.println(steps);
                    }
                    break;
                } else if ((d-distanceCovered) >= b) {
//                while (distanceLeftToCover >= a) {
//                    if (distanceLeftToCover >= b) {
                    distanceCovered += b;
                    System.out.println(distanceCovered);
                    steps++;
//                    } else {
//                        break;
//                    }
//                }
//                while (distanceLeftToCover >= a) {
//                    distanceLeftToCover -= a;
//                    steps++;
//                }
                } 
//                else if ((d-distanceCovered) >= a && (d-distanceCovered) < b) {
////                while (distanceLeftToCover >= a) {
//                    distanceCovered += a;
//                    System.out.println(distanceCovered);
//                    steps++;
////                }
//                }
                else if ((d-distanceCovered) < a) {
//                int i = 0;
//                if (distanceLeftToCover != 0) {
//                    while ((distanceLeftToCover - ((b - a) * ++i)) != 0) {
//                    }
//                }
//                System.out.println(steps + i * 2);
//                System.out.println("2");
                    System.out.println(distanceCovered);
                    steps += 2;
                    System.out.println(steps);
                    break;
                }
//            System.out.println("Distance left to Cover:" + distanceLeftToCover);
//            
//            System.out.println("Steps:" + steps);
//            if(distanceLeftToCover==0){
//                System.out.println(steps);
//            }else{
//                System.out.println(steps + 2);
//            }
            }
        }
    }
}
