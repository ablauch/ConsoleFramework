package javaclasses;

import java.util.Scanner;

/**
 * Created by ablauch on 5/10/2018.
 * test conditional statements
 */
public class TestConditions {

    public static void main(String arg[]) {
        int n=5;

        System.out.println("Sample Conditional Statements Program");

        System.out.println("Please a number between 1 and 10: ");
//        n = sc.nextInt();

        if (n < 1) {
            System.out.println("You entered a number less than 1");
        }
        if (n > 10) {
            System.out.println("You entered a number greater than 10");
        }
        System.out.println("You entered "+n);
    }

}
