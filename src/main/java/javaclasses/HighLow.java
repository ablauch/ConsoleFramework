package javaclasses;

import java.util.Random;


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
    static MyConsole Console = null;
    static enum GAME_MODE {MODE_P1_P2, MODE_P1_C, MODE_P2_P1, MODE_C_P1};

    /* game settings */
    private static int	minNumber=1, maxNumber=10;
    private static int	levelComputer=1;
    private static boolean bRepeat=false, bComputer=false, bPlayerFirst=true;


    /*
     * This function gets an integer from the user and
     * makes sure it is within the specified range (inclusive)
     *
     * Parameters:
     *  prompt : text to display to user
     * 	min :  minimum value
     * 	max :  maximum value
     *
     * Returns:
     * 	User input value
     */
    private static int GetInput(String prompt, int min, int max)
    {
        int value;

        System.out.println(prompt);
        System.out.print("Range ["+min+","+max+"]: ");
        do {
            value = Console.getInt();
            if ( (value<min) || (value>max) ) {
                System.out.println("   Value is outside valid range!");
                System.out.print("Reenter value in range ["+min+","+max+"]: ");
            }
        }
        while ( (value<min) || (value>max) );
        return value;
    }


    /*
     * This function plays the hi low guessing game
     *
     * Parameters:
     * 	mode :     determines who is playing (see gm enumeration)
     *
     * Returns:
     * 	Number of guesses
     */
    private static int PlayGame(GAME_MODE mode)
    {
        Random rand = new Random();    /* random number for computer guesses */
        int	cvalue=0;		/* correct value */
        int	gvalue=0;		/* guess value */
        int	nguess=0;		/* number of guesses */
        int	lower, upper, range;	/* Used for computer guessing algorithm */

        /* First person picks a number
         */
        Console.clearScreen();
        switch (mode) {
            case MODE_P1_P2:
            case MODE_P1_C:                /* Player 1 picks */
                cvalue = GetInput("Player 1 PICK a number",minNumber,maxNumber);
                break;
            case MODE_P2_P1:                /* Player 2 picks */
                cvalue = GetInput("Player 2 PICK a number",minNumber,maxNumber);
                break;
            case MODE_C_P1:                /* Computer picks */
                cvalue = minNumber + rand.nextInt((maxNumber - minNumber) + 1);
                break;
        }
        Console.clearScreen();

        /* Start guessing sequence
         */
        nguess = 0;	/* Initialize number of guesses */
        lower = minNumber;	/* Initialize limits for computer guessing */
        upper = maxNumber;
        do {
            nguess = nguess+1;	/* Increment number of guesses */

            /* Second person guesses a number
             */
            switch (mode) {
                case MODE_P2_P1:
                case MODE_C_P1:                    /* Player 1 guesses */
                    gvalue = GetInput("Player 1 GUESS a number",minNumber,maxNumber);
                    break;
                case MODE_P1_P2:                    /* Player 2 guesses */
                    gvalue = GetInput("Player 2 GUESS a number",minNumber,maxNumber);
                    break;
                case MODE_P1_C:                    /* Computer guesses */
                    switch (levelComputer) {
                        case 1:                            /* 'Stupid' */
                            gvalue = minNumber + rand.nextInt((maxNumber - minNumber) + 1);
                            break;
                        case 2:                            /* 'Smart' */
                            gvalue = (lower+upper)/2;
                            break;
                        case 3:                            /* 'Smarter' */
                            range = (upper-lower)/3+1;
                            gvalue = (lower+upper)/2 + rand.nextInt(range) - range/2;
                            break;
                    }
                    System.out.println("The computer guesses "+gvalue);
                    break;
            }

            /* Compare correct number and guess
             * Display result
             */
            if (cvalue < gvalue) {                  /* Correct value lower than guess */
                System.out.println("   The guess was too high!");
                upper = gvalue - 1;
            } else if (cvalue > gvalue) {           /* Correct value higher than guess */
                System.out.println("   The guess was too low!");
                lower = gvalue + 1;
            } else {                                /* Correct */
                System.out.println("   The guess was correct!");
            }

            /* Repeat until correct */
        } while ( cvalue != gvalue );

        /* Display number of guesses
         */
        switch (mode) {
            case MODE_P2_P1:
            case MODE_C_P1:                /* Player 1 guessed */
                System.out.println("Player 1, it took you "+nguess+" guesses.");
                break;
            case MODE_P1_P2:                /* Player 2 guessed */
                System.out.println("Player 2, it took you "+nguess+" guesses.");
                break;
            case MODE_P1_C:                /* Computer guessed */
                System.out.println("It took the computer "+nguess+" guesses.");
                break;
        }
        System.out.println("Press any key to continue...");
        Console.getChar();
        System.out.println();

        /* Return number of guesses */
        return nguess;
    }


    /*
     * This function gets the game settings
     */
    private static void GetGameSettings()
    {
        char key;

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
            System.out.print("Do you want to pick first (computer guesses) [Y/N]? ");
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

        /* display game settings */
        System.out.println();
        System.out.println("Game Settings");
        System.out.println("Range ["+minNumber+","+maxNumber+"]");
        if (bComputer) {
            System.out.println("Player vs Computer");
            System.out.println("   Level "+levelComputer);
            if (bPlayerFirst)
                System.out.println("   Player picks first (computer guesses)");
            else
                System.out.println("   Computer picks first (player guesses)");
        } else {
            System.out.println("Two Player Game");
        }
        System.out.println("Press any key to continue...");
        Console.getChar();
        System.out.println();
    }


    /*
    * Main program
     */
    public static void main(String arg[]) {
        char key;

        /* game results */
        int	guessesPlayerA, guessesPlayerB;
        int	winsPlayerA, winsPlayerB;

        /* create console object for user input */
        Console = new MyConsole();

        System.out.println("High Low Guessing Game");

        /* Get game settings */
        GetGameSettings();

        /* initialize number of wins for each player */
        winsPlayerA = 0;
        winsPlayerB = 0;

        /* play game */
        do {
            if ( bComputer ) {      /* One player game */
                if ( bPlayerFirst ) {
                    guessesPlayerB = PlayGame(GAME_MODE.MODE_P1_C);
                    guessesPlayerA = PlayGame(GAME_MODE.MODE_C_P1);
                } else {
                    guessesPlayerA = PlayGame(GAME_MODE.MODE_C_P1);
                    guessesPlayerB = PlayGame(GAME_MODE.MODE_P1_C);
                }
            } else {                /* Two player game */
                guessesPlayerA = PlayGame(GAME_MODE.MODE_P1_P2);
                guessesPlayerB = PlayGame(GAME_MODE.MODE_P2_P1);
            }

            /* Display winner */
            Console.clearScreen();
            if ( guessesPlayerA>guessesPlayerB ) {
                winsPlayerB++;
                if (bComputer)
                    System.out.println("The computer wins!");
                else
                    System.out.println("Player 2 wins!");
            } else if ( guessesPlayerA<guessesPlayerB) {
                winsPlayerA++;
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("It was a tie!");
            }

            /* Display number of wins for each player */
            System.out.println("Player 1 has won "+winsPlayerA+" times!");
            if ( bComputer )
                System.out.println("Computer has won "+winsPlayerB+" times!");
            else
                System.out.println("Player 2 has won "+winsPlayerB+" times!");

            /* ask to play again */
            System.out.print("Play again [Y/N]? ");
            do {
                key = Character.toUpperCase(Console.getChar());
            } while ( (key!='N') && (key!='Y') );
            bRepeat = (key=='Y');

        } while ( bRepeat );

        System.exit(0);
    }
}
