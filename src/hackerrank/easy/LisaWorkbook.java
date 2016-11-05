/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.easy;

import java.util.Scanner;

/**
 *
 * @author Poonawala
 */
public class LisaWorkbook {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int pagesPerChapter[] = new int[n];
        int totalPages = 0;
        int pageNoOfBook = 1;
        int specials = 0;
        for (int i = 0; i < n; i++) {
            int problems = in.nextInt();
            pagesPerChapter[i] = (problems / k) + ((problems % k) == 0 ? 0 : 1);
            totalPages += pagesPerChapter[i];
            for (int page = 1; page <= pagesPerChapter[i]; page++) {
                if (page == 1) {
                    if (pageNoOfBook <= (page * k) && problems>=pageNoOfBook) {
                        specials++;
//                        System.out.println("Plus at:" + (i + 1));
                    }
                } else if (pageNoOfBook <= (page * k) && pageNoOfBook > ((page - 1) * k)) {
//                    System.out.println("Plus at:" + (i + 1) + " not at 1");
                    specials++;
                }
                pageNoOfBook++;
            }
        }
        System.out.println(specials);
    }
}
