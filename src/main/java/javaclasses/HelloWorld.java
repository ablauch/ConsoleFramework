package javaclasses;

import java.util.Scanner;

/**
 * Created by adamhurwitz on 2/27/16.
 */
public class HelloWorld {
    static private final String LOG_TAG = HelloWorld.class.getSimpleName();
    static double x = 3;
    static double n = 5;

    public static void main(String arg[]) {

// Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println("This program will calculate x^n");
        System.out.println("Enter x\r");
//        x = in.nextDouble();
        System.out.println("Enter n\r");
//        n = in.nextDouble();

        System.out.println("power equals " + pow(x, n));
    }

    public static double pow(double x, double n) {
        double y;

        if (n == 0) {
            return 1;
        } else if (n > 0 && n % 2 == 0) {
            y = Math.pow(x, (n / 2));
            return y * y;
        } else if (n > 0 && n % 2 == 1) {
            y = Math.pow(x, (n - 1));
            return y * x;
        } else {
            return 1 / (Math.pow(x, -1 * n));
        }
    }
}

