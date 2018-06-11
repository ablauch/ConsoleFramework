package javaclasses;

/*
AUTHOR:		Dr. Andrew Blauch
DESCRIPTION:	High Low Guessing Game
FEATURES:
	Selectable range
	Two Player Game
	One Player Game (against computer)
		Pick or guess first
		Difficulty level
	Play again
*/
public class HighLow {

    public static void main(String arg[]) {
        MyConsole Console = new MyConsole();
        char key;

        /* game settings */
        int	minNumber, maxNumber;
        int	levelComputer;
        boolean bRepeat, bComputer, bPlayerFirst;

        /* game results */
        int	guessesPlayerA, guessesPlayerB;
        int	winsPlayerA, winsPlayerB;

        System.out.println("High Low Guessing Game");

        /*********
         * Get game settings
         *********/

        /* Get number range */
        System.out.print("Please input the minimum number: ");
        minNumber = Console.getInt();
        System.out.print("Please input the maximum number: ");
        do {
            maxNumber = Console.getInt();
            if (minNumber>maxNumber) {
                System.out.println("   Maximum must be greater than minimum.");
                System.out.print("Reenter value: ");
            }
        } while (minNumber>maxNumber);

        /* Get one or two player option */
        System.out.print("Do you want to play against the computer [Y/N]? ");
        do {
            key = Character.toUpperCase(Console.getChar());
        } while ( (key!='N') && (key!='Y') );
        bComputer = (key=='Y');
        System.out.println();

        /* Get additional one player options */
        if ( bComputer ) {
            /* Ask who goes first */
            System.out.print("Do you want to pick first [Y/N]? ");
            do {
                key = Character.toUpperCase(Console.getChar());
            } while ( (key!='N') && (key!='Y') );
            bPlayerFirst = (key=='Y');
            System.out.println();

            /* Get difficulty level */
            System.out.print("Please enter difficulty level [1..3]: ");
            do {
                levelComputer = Console.getInt();
                if ((levelComputer<1) || (levelComputer>3)) {
                    System.out.println("   Invalid difficulty level.");
                    System.out.print("Reenter value: ");
                }
            } while ((levelComputer<1) || (levelComputer>3));
        }

        System.out.println();
        System.out.println("Game Settings");
        System.out.println("Range ["+minNumber+","+maxNumber+"]");

        System.exit(0);
    }
}
