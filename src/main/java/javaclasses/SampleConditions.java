package javaclasses;

/**
 * Created by ablauch on 5/10/2018.
 * test conditional statements
 */
public class SampleConditions {

    public static void main(String arg[]) {
        MyConsole Console = new MyConsole();    // declare a new object
        int n = 5;

        System.out.println("Sample Conditional Statements Program");

        System.out.println("Please enter a number between 1 and 10: ");
        n = Console.getInt();

        if (n < 1) {
            System.out.println("You entered a number less than 1");
        }
        if (n > 10) {
            System.out.println("You entered a number greater than 10");
        } else {
            System.out.println("You entered a number not greater than 10");
        }

        do {
            System.out.println("Count down to zero " + n);
            n = n - 1;
        } while (n > 0);

        /* close everything */
        System.exit(0);
    }
}
