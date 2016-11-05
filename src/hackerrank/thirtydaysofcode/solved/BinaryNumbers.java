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
public class BinaryNumbers {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(maxSequenceOf(n, "1"));
    }

    /**
     * Converts a base 10 integer to its binary representation
     *
     * @param base10Number input number
     * @return String binary representation of the number
     */
    private static String toBinary(int base10Number) {
        StringBuilder binaryRepresentation = new StringBuilder();
        while (base10Number > 0) {
            binaryRepresentation.insert(0, base10Number % 2);
            base10Number = base10Number / 2;
        }
        return binaryRepresentation.toString();
    }

    /**
     * Returns the maximum length of matching charSequence in the binary
     * representation of the given base10Number
     *
     * @param base10Number input decimal number
     * @param charSequence string to match in binary representation
     * @return integer max sequence length matching
     */
    private static int maxSequenceOf(int base10Number, String charSequence) {
        int maxSequenceLength = 0;
        int currentSequenceLength = 0;
        while (base10Number > 0) {
            if (((base10Number % 2) + "").equalsIgnoreCase(charSequence)) {
                currentSequenceLength++;
                if (maxSequenceLength < currentSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                }
            } else {
                currentSequenceLength = 0;
            }
            base10Number = base10Number / 2;
        }
        return maxSequenceLength;
    }

    /**
     * Converts a binary String representation to its integer value.
     *
     * @param binaryNumber binary String
     * @return decimal value of the input String
     */
    private static int toDecimal(String binaryNumber) {
        int length = binaryNumber.length() - 1;
        int decimalValue = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            decimalValue += (int) Math.pow(2, length - i) * Integer.parseInt(binaryNumber.charAt(i) + "");
        }
        return decimalValue;
    }

    /**
     * Finds the decimal value of sequence of 1's of given length
     *
     * @param length
     * @return decimal value of sequence of 1's of given length
     */
    private static int decimalValue(int length) {
        int decimalValue = 0;
        for (int i = 1; i <= length; i++) {
            decimalValue += (int) Math.pow(2, length - i);//* 1 is redundant here
        }
        return decimalValue;
    }
}
