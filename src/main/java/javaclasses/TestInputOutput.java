package javaclasses;

import java.util.Scanner;

/**
 * Created by ablauch on 5/10/2018.
 * test console input and output
 */
public class TestInputOutput {
    static private final String LOG_TAG = TestInputOutput.class.getSimpleName();

    public static void main(String arg[]) {
        String s = "hello";
        int i = 1;
        double d = 2.3;

        // Using Scanner for Getting Input from User
        Scanner sc = new Scanner(System.in);

        System.out.println(LOG_TAG);

        System.out.println("String is "+s);
        System.out.println("Please enter string: ");
        s = sc.next();
        System.out.println("You entered "+s);

        System.out.println("Integer is "+i);
        System.out.println("Please enter integer: ");
        i = sc.nextInt();
        System.out.println("You entered "+i);

        System.out.println("Double is "+d);
        System.out.println("Please enter double: ");
        d = sc.nextDouble();
        System.out.println("You entered "+d);
    }

}

