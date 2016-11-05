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
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int jumps = 0;
        in.nextInt();
        boolean flag = true;
        for (int i = 1; i < n; jumps++, i++) {
            if (i >= (n - 3)) {
                jumps++;
                if(i==n-2){
                    jumps++;
                }
                break;
            }
            in.nextInt();//next Value
            int nextPlus = in.nextInt();
            if (nextPlus == 0) {
                i++;
            } else {
                flag = false;
            }

        }

        System.out.println(jumps);*/
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }
        int count = -1;
        for (int i = 0; i < n; i++, count++) {
            if (i<n-2 && c[i+2]==0) i++;
        }
        System.out.println(count);
        //can be done using above previous and next input method just difficult to manage number of inputs in that case
    }
}
