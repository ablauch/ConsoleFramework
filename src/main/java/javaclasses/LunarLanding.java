package javaclasses;

public class LunarLanding {

    public static void main(String arg[]) {
        MyConsole console = new MyConsole();
        char key;

        System.out.println("Lunar Landing Game");
        System.out.println("Options:");
        System.out.println(" w - Enters integer");
        System.out.println(" q - Quits");
        System.out.println(" ? - Displays help");

        do {
            key = console.getKey(true);
            switch (key) {
                case 0:
                    break;
                case '?':
                    System.out.println("Options:");
                    System.out.println(" w - Enters integer");
                    System.out.println(" q - Quits");
                    System.out.println(" ? - Displays help");
                    break;
                case 'w':
                    System.out.println();
                    System.out.print("Enter integrer: ");
                    int x = console.getInt();
                    System.out.println("You entered "+x);
                    break;
                default:
                    break;
            }
        }
        while (key!='q');

        System.out.println();
        System.out.println("Good bye!");

        System.exit(0);
    }
}
