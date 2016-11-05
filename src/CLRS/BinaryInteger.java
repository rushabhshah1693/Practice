/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLRS;

/**
 * Converts a decimal integer to binary
 * <p>
 * Performs binary functions and prints the result in binary form.</p>
 *
 * @author Poonawala
 */
public class BinaryInteger {

    private String binaryInt;

    /**
     *
     * @param n initialize with decimal integer
     */
    public BinaryInteger(int n) {
        binaryInt = generateBinary(n);
    }

    public BinaryInteger(String binaryInt) {
        this.binaryInt = binaryInt;
    }

    public static void main(String[] args) {
        BinaryInteger bi1 = new BinaryInteger(10);
        BinaryInteger bi2 = new BinaryInteger(1000);
        System.out.println(bi1.add(bi2));
    }

    /**
     *
     * @param number to convert to binary
     * @return String binary representation
     */
    private String generateBinary(int number) {
        if (number == 0) {
            return "0000";
        }
        System.out.println(Integer.toBinaryString(number));
        return Integer.toBinaryString(number);
    }

    /**
     *
     * @param binaryInt binary integer to add
     * @return binary String representation of sum of the two binary integers
     */
    public BinaryInteger add(BinaryInteger binaryInt) {
        String binaryIntRepresentation = binaryInt.getBinaryInt();
        String currentValue = this.binaryInt;
        if (binaryIntRepresentation.equalsIgnoreCase("0")) {
            return new BinaryInteger(this.binaryInt);
        }
        if (binaryIntRepresentation.length() > currentValue.length()) {
            currentValue = padZeros(binaryIntRepresentation.length() - currentValue.length()) + currentValue;
        } else if (binaryIntRepresentation.length() < currentValue.length()) {
            binaryIntRepresentation = padZeros(currentValue.length() - binaryIntRepresentation.length()) + binaryIntRepresentation;
        }
//        System.out.println("current value is:" + currentValue);
        int carry = 0;
        StringBuilder sum = new StringBuilder("");
        for (int i = binaryIntRepresentation.length() - 1; i >= 0; i--) {
            sum.insert(0, (carry + binaryIntRepresentation.charAt(i) + currentValue.charAt(i)) % 2);
            carry = (carry + binaryIntRepresentation.charAt(i) + currentValue.charAt(i)) / 2;
            System.out.println((carry + binaryIntRepresentation.charAt(i) + currentValue.charAt(i)) % 2);
//            System.out.println("carry is:" + (carry + binaryIntRepresentation.charAt(i) + currentValue.charAt(i)) % 2);
        }
        return new BinaryInteger(sum.toString());
    }

    /**
     * generates a string of zeros of given length
     *
     * @param length of the string
     * @return {@link String} string of all 0's of the given length
     */
    private String padZeros(int length) {
        String zeros = "";
        for (int i = 1; i <= length; i++) {
            zeros += "0";
        }
        return zeros;

    }

    @Override
    public String toString() {
        return binaryInt;
    }

    public String getBinaryInt() {
        return binaryInt;
    }

    public void setBinaryInt(String binaryInt) {
        this.binaryInt = binaryInt;
    }

}
