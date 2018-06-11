package javaclasses;

/**
 * Created by ablauch on 5/10/2018.
 * test console input and output
 */
public class SampleInputOutput {

    public static void main(String arg[]) {
        /**
         *  declarations at beginning of method
         * these variables/objects are only available in this method
         */
        MyConsole Console = new MyConsole();    // declare a new object
        String name = "Dr. Andrew Blauch";      // declare and initialize variables
        char key = 'A';
        int number = 23;
        double real_number = 2.3;

        System.out.println("Sample Input Output Program");

        /* show how to display information */
        System.out.println("This is how you display a complete line.");
        System.out.print("This is how you display part");
        System.out.print(" of a line ");
        System.out.println(" and then end the line.");

        System.out.println("Display a variable like this "+number+" and this "+real_number);
        System.out.println("and like this "+key+" and this "+name);

        /* show how to get information */
        System.out.print("Please enter an integer: ");
        number = Console.getInt();
        System.out.println("You entered "+number);

        System.out.print("Please enter a double: ");
        real_number = Console.getDouble();
        System.out.println("You entered "+real_number);

        System.out.print("Please enter a character: ");
        key = Console.getChar();
        System.out.println("");                 // getChar does not go to next line
        System.out.println("You entered "+key);

        System.out.print("Please enter a string: ");
        name = Console.getString();
        System.out.println("You entered "+name);

        /* close everything */
        System.exit(0);
    }
}
