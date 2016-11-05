/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.thirtydaysofcode.solved;

/**
 *
 * @author Poonawala
 */
import java.util.*;
import java.io.*;

public class MoreExceptions {

    static class Calculator {

        int power(int n, int p) throws Exception {
            if (n < 0 || p < 0) {
                throw new Exception("n and p should be non-negative");
            } else {
                return n ^ p;
            }
        }
    }

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
