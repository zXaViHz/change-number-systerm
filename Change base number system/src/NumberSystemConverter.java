/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
package J1.S.P0011;

import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
import java.util.Scanner;

public class NumberSystemConverter {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1]*";
    private static final String DECIMAL_VALID = "[0-9]*";
    private static final String HEXADECIMAL_VALID = "[0-9A-F]*";

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputBinary() {
        System.out.print("Enter a binary number: ");
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.matches(BINARY_VALID)) {
                return result;
            }
            System.err.println("Invalid input. Only 0 and 1 are allowed.");
            System.out.print("Enter again: ");
        }
    }

    public String checkInputDecimal() {
        System.out.print("Enter a decimal number: ");
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.matches(DECIMAL_VALID)) {
                return result;
            }
            System.err.println("Invalid input. Only digits (0-9) are allowed.");
            System.out.print("Enter again: ");
        }
    }

    public String checkInputHexadecimal() {
        System.out.print("Enter a hexadecimal number: ");
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.matches(HEXADECIMAL_VALID)) {
                return result;
            }
            System.err.println("Invalid input. Only digits (0-9) and letters (A-F) are allowed.");
            System.out.print("Enter again: ");
        }
    }

    public void runConverter() {
        System.out.println("Number System Converter");
        System.out.println("1. Convert Binary to Decimal");
        System.out.println("2. Convert Decimal to Binary");
        System.out.println("3. Convert Decimal to Hexadecimal");
        System.out.println("4. Convert Hexadecimal to Decimal");
        System.out.print("Enter your choice): ");
        int choice = checkInputIntLimit(1, 4);
        switch (choice) {
            case 1:
                String binaryNumber = checkInputBinary();
                int decimalNumber = Integer.parseInt(binaryNumber, 2);
                System.out.println("Decimal equivalent: " + decimalNumber);
                break;
            case 2:
                String decimalInput = checkInputDecimal();
                int decimalValue = Integer.parseInt(decimalInput);
                String binaryValue = Integer.toBinaryString(decimalValue);
                System.out.println("Binary equivalent: " + binaryValue);
                break;
            case 3:
                String decimalInput2 = checkInputDecimal();
                int decimalValue2 = Integer.parseInt(decimalInput2);
                String hexadecimalValue = Integer.toHexString(decimalValue2).toUpperCase();
                System.out.println("Hexadecimal equivalent: " + hexadecimalValue);
                break;
            case 4:
                String hexadecimalInput = checkInputHexadecimal();
                int decimalValue3 = Integer.parseInt(hexadecimalInput, 16);
                System.out.println("Decimal equivalent: " + decimalValue3);
                break;
            default:
                System.err.println("Invalid choice.");
        }
    }
}
