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
public class Pig {
    static MyConsole Console = null;
    static Random Rand = null;
    static final int POINTS_TO_WIN = 20;

    static boolean GetYesNo(String prompt) {
        char key;

        System.out.print(prompt);
        do {
            key = Character.toUpperCase(Console.checkKey());
        } while ((key != 'N') && (key != 'Y'));
        return (key == 'Y');
    }

    static private class Player {
        private int scoreTotal = 0;
        private boolean bComputer = true;
        private String namePlayer = "Computer";

        Player() {
            bComputer = true;
            namePlayer = "Computer";
        }

        Player(String name) {
            bComputer = false;
            namePlayer = name;
        }

        private boolean TakeTurn() {
            int score = 0;
            int die;
            int countdown;
            boolean repeat;

            System.out.println(namePlayer + "'s turn.");
            System.out.printf("     Points this turn: %3d  Total points: %3d", score, scoreTotal + score);
            if (bComputer) {
                System.out.print("     Let's roll the die...");
                Console.sleep(1000);
            } else {
                System.out.print("     Press any key to roll die...");
                while (Console.checkKey() == 0) ;
            }

            do {
                countdown = 10;
                do {
                    die = Rand.nextInt(6) + 1;
                    System.out.printf("\r     %d", die);
                    Console.sleep(250);
                }
                while ((countdown--) > 0);

                System.out.printf("\r");
                System.out.printf("     You rolled a %d", die);

                repeat = false;
                if (die != 1) {
                    score += die;
                    System.out.printf("     Points this turn: %3d  Total points: %3d", score, scoreTotal + score);
                    if (scoreTotal + score < POINTS_TO_WIN) {
                        if (bComputer) {
                            if (score<10) {
                                System.out.print("     Let's roll the die...");
                                repeat = true;
                            }
                            else {
                                System.out.print("     Let's stay...");
                                repeat = false;
                            }
                            Console.sleep(1000);
                        } else {
                            repeat = GetYesNo("     Do you want to roll again (Y/N)?");
                        }
                    }
                } else {
                    score = 0;
                }
            }
            while (repeat);

            scoreTotal += score;

            if (scoreTotal >= POINTS_TO_WIN) {
                System.out.println("     You win !!");
                return true;
            }

            if (score == 0) {
                System.out.print("     Busted !!");

                if (bComputer) {
                    System.out.print("     Oh bother...");
                    Console.sleep(1000);
                } else {
                    System.out.print("     Press any key to roll die...");
                    while (Console.checkKey() == 0) ;
                }
            }

            System.out.printf("\r");
            System.out.printf("     Total points: %3d\n", scoreTotal);

            return false;
        }
    }

    /* game settings */
    private static int levelComputer = 1;
    private static boolean bRepeat = false, bComputer = false, bPlayerFirst = true;

    /*
     * Main program
     */
    public static void main(String arg[]) {
        Console = new MyConsole();      /* create console object for user input */
        Rand = new Random();            /* create randome object */
        boolean done;

        Player Player1 = new Player("Player");
        Player Player2 = new Player();

        System.out.println("PIG Dice Game");

        done = false;
        do {
            done = Player1.TakeTurn();
            if (!done)
                done = Player2.TakeTurn();
        } while (!done);

        System.exit(0);
    }
}
