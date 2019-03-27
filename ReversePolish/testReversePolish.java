package com.reversePolishNotation;

import java.util.Scanner;

/**
 * test for reversePolish.java
 */
public class testReversePolish {
    public static void main(String[] args){
        String input;
        System.out.println("Enter infix:");
        //A*(B+C)-D/(E+F)
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        reversePolish in = new reversePolish(input);
        MyCharStack my = in.doTransfer();
        my.displayStack();
    }
}
