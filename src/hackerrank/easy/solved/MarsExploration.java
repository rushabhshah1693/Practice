/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy.solved;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class MarsExploration {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String message = in.next();
        int count = 0;
        for (int loop = 0; loop < message.length(); loop ++) {
            if(message.charAt(loop)!='S'){
                count++;
            }
            if(message.charAt(++loop)!='O'){
                count++;
            }
            if(message.charAt(++loop)!='S'){
                count++;
            }
        }
        System.out.println(count);
    }
}
