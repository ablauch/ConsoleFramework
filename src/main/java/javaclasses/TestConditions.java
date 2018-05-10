package javaclasses;

import java.util.Scanner;

/**
 * Created by ablauch on 5/10/2018.
 * test conditional statements
 */
public class TestConditions {
    static private final String LOG_TAG = TestConditions.class.getSimpleName();

    public static void main(String arg[]) {
        int n;

        // Using Scanner for Getting Input from User
        Scanner sc = new Scanner(System.in);

        System.out.println(LOG_TAG);

        System.out.println("Please a number between 1 and 10: ");
        n = sc.nextInt();

        if (n < 1) {
            System.out.println("You entered a number less than 1");
        }
        if (n > 10) {
            System.out.println("You entered a number greater than 10");
        }
        System.out.println("You entered "+n);
    }

}

