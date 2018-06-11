package javaclasses;
import java.util.Random;

public class HighLowBadBadCode {
    static MyConsole C = null;
    private static int mn =1, mx =10;
    private static int lv =1;
    private static boolean rp =false, cp =false, f =true;
    public static void main(String arg[]) {
        char key;
        int	ga, gb;
        int	wa, wb;
        Random rand = new Random();
        int	c=0, g=0, n=0, l, u, r;
        C = new MyConsole();
        System.out.println("High Low Guessing Game");
        System.out.print("Please input the minimum number: ");
        mn = C.getInt();
        System.out.print("Please input the maximum number: ");
        do {
        mx = C.getInt();
        if (mn > mx) {
        System.out.println("   Maximum must be greater than minimum.");
        System.out.print("Reenter value: "); }
        } while (mn > mx);
        System.out.print("Do you want to play against the computer [Y/N]? ");
        do {
        key = Character.toUpperCase(C.getChar());
        } while ( (key!='N') && (key!='Y') );
        cp = (key=='Y');
        System.out.println();
        if (cp) {
        System.out.print("Do you want to pick first (computer guesses) [Y/N]? ");
        do {
        key = Character.toUpperCase(C.getChar());
        } while ( (key!='N') && (key!='Y') );
        f = (key=='Y');
        System.out.println();
        System.out.print("Please enter difficulty level [1..3]: ");
        do {
        lv = C.getInt();
        if ((lv <1) || (lv >3)) {
        System.out.println("   Invalid difficulty level.");
        System.out.print("Reenter value: "); }
        } while ((lv <1) || (lv >3)); }
        System.out.println();
        System.out.println("Game Settings");
        System.out.println("Range ["+ mn +","+ mx +"]");
        if (cp) {
        System.out.println("Player vs Computer");
        System.out.println("   Level "+ lv);
        if (f)
        System.out.println("   Player picks first (computer guesses)");
        else
        System.out.println("   Computer picks first (player guesses)");
        } else {
        System.out.println("Two Player Game"); }
        System.out.println("Press any key to continue...");
        C.getChar();
        System.out.println();
        wa = 0;
        wb = 0;
        do {
        if (cp) {
        if (f) {
            {
                C.clearScreen();
                {
                    int value;
                    System.out.println("Player 1 PICK a number");
                    System.out.print("Range ["+mn+","+mx+"]: ");
                    do {
                        value = C.getInt();
                        if ( (value<mn) || (value>mx) ) {
                            System.out.println("   Value is outside valid range!");
                            System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                    while ( (value<mn) || (value>mx) );
                    c = value;
                }
                C.clearScreen();
                n = 0;
                l = mn;
                u = mx;
                do {
                    n = n+1;
                            switch (lv) {
                                case 1:
                                    g = mn + rand.nextInt((mx - mn) + 1);
                                    break;
                                case 2:
                                    g = (l+u)/2;
                                    break;
                                case 3:
                                    r = (u-l)/3+1;
                                    g = (l+u)/2 + rand.nextInt(r) - r/2;
                                    break; }
                            System.out.println("The computer guesses "+g);
                    if (c < g) {
                        System.out.println("   The guess was too high!");
                        u = g - 1;
                    } else if (c > g) {
                        System.out.println("   The guess was too low!");
                        l = g + 1;
                    } else {
                        System.out.println("   The guess was correct!"); }
                } while ( c != g );
                System.out.println("It took the computer "+n+" guesses.");
                System.out.println("Press any key to continue...");
                C.getChar();
                System.out.println();
                gb = n;
            }
            {
                C.clearScreen();
                c = mn + rand.nextInt((mx - mn) + 1);
                C.clearScreen();
                n = 0;
                l = mn;
                u = mx;
                do {
                    n = n+1;
                        {
                            int value;
                            System.out.println("Player 1 GUESS a number");
                            System.out.print("Range ["+mn+","+mx+"]: ");
                            do {
                                value = C.getInt();
                                if ( (value<mn) || (value>mx) ) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                            while ( (value<mn) || (value>mx) );
                            g = value;
                        }
                    if (c < g) {
                        System.out.println("   The guess was too high!");
                        u = g - 1;
                    } else if (c > g) {
                        System.out.println("   The guess was too low!");
                        l = g + 1;
                    } else {
                        System.out.println("   The guess was correct!"); }
                } while ( c != g );
                        System.out.println("Player 1, it took you "+n+" guesses.");
                System.out.println("Press any key to continue...");
                C.getChar();
                System.out.println();
                ga = n;
            }
        } else {
            {
                C.clearScreen();
                c = mn + rand.nextInt((mx - mn) + 1);
                C.clearScreen();
                n = 0;
                l = mn;
                u = mx;
                do {
                    n = n + 1;
                    int value;
                    System.out.println("Player 1 GUESS a number");
                    System.out.print("Range [" + mn + "," + mx + "]: ");
                    do {
                        value = C.getInt();
                        if ((value < mn) || (value > mx)) {
                            System.out.println("   Value is outside valid range!");
                            System.out.print("Reenter value in range [" + mn + "," + mx + "]: ");
                        }
                    }
                    while ((value < mn) || (value > mx));
                    g = value;
                    if (c < g) {
                        System.out.println("   The guess was too high!");
                        u = g - 1;
                    } else if (c > g) {
                        System.out.println("   The guess was too low!");
                        l = g + 1;
                    } else {
                        System.out.println("   The guess was correct!");
                    }
                } while (c != g);
                System.out.println("Player 1, it took you " + n + " guesses.");
                System.out.println("Press any key to continue...");
                C.getChar();
                System.out.println();
                ga = n;
            }
            {
                gm m = gm.P1C;
                C.clearScreen();
                switch (m) {
                    case P12:
                    case P1C: {
                        int value;
                        System.out.println("Player 1 PICK a number");
                        System.out.print("Range [" + mn + "," + mx + "]: ");
                        do {
                            value = C.getInt();
                            if ((value < mn) || (value > mx)) {
                                System.out.println("   Value is outside valid range!");
                                System.out.print("Reenter value in range [" + mn + "," + mx + "]: ");
                            }
                        }
                        while ((value < mn) || (value > mx));
                        c = value;
                    }
                    break;
                    case P21: {
                        int value;
                        System.out.println("Player 2 PICK a number");
                        System.out.print("Range [" + mn + "," + mx + "]: ");
                        do {
                            value = C.getInt();
                            if ((value < mn) || (value > mx)) {
                                System.out.println("   Value is outside valid range!");
                                System.out.print("Reenter value in range [" + mn + "," + mx + "]: ");
                            }
                        }
                        while ((value < mn) || (value > mx));
                        c = value;
                    }
                    break;
                    case PC1:
                        c = mn + rand.nextInt((mx - mn) + 1);
                        break;
                }
                C.clearScreen();
                n = 0;
                l = mn;
                u = mx;
                do {
                    n = n + 1;
                    switch (m) {
                        case P21:
                        case PC1: {
                            int value;
                            System.out.println("Player 1 GUESS a number");
                            System.out.print("Range [" + mn + "," + mx + "]: ");
                            do {
                                value = C.getInt();
                                if ((value < mn) || (value > mx)) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range [" + mn + "," + mx + "]: ");
                                }
                            }
                            while ((value < mn) || (value > mx));
                            g = value;
                        }
                        break;
                        case P12: {
                            int value;
                            System.out.println("Player 2 GUESS a number");
                            System.out.print("Range [" + mn + "," + mx + "]: ");
                            do {
                                value = C.getInt();
                                if ((value < mn) || (value > mx)) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range [" + mn + "," + mx + "]: ");
                                }
                            }
                            while ((value < mn) || (value > mx));
                            g = value;
                        }
                        break;
                        case P1C:
                            switch (lv) {
                                case 1:
                                    g = mn + rand.nextInt((mx - mn) + 1);
                                    break;
                                case 2:
                                    g = (l + u) / 2;
                                    break;
                                case 3:
                                    r = (u - l) / 3 + 1;
                                    g = (l + u) / 2 + rand.nextInt(r) - r / 2;
                                    break;
                            }
                            System.out.println("The computer guesses " + g);
                            break;
                    }
                    if (c < g) {
                        System.out.println("   The guess was too high!");
                        u = g - 1;
                    } else if (c > g) {
                        System.out.println("   The guess was too low!");
                        l = g + 1;
                    } else {
                        System.out.println("   The guess was correct!");
                    }
                } while (c != g);
                switch (m) {
                    case P21:
                    case PC1:
                        System.out.println("Player 1, it took you " + n + " guesses.");
                        break;
                    case P12:
                        System.out.println("Player 2, it took you " + n + " guesses.");
                        break;
                    case P1C:
                        System.out.println("It took the computer " + n + " guesses.");
                        break;
                }
                System.out.println("Press any key to continue...");
                C.getChar();
                System.out.println();
                gb = n;
            }
        }
        } else {
                {
                    gm m = gm.P12;
                    C.clearScreen();
                    switch (m) {
                        case P12:
                        case P1C:
                        {
                            int value;
                            System.out.println("Player 1 PICK a number");
                            System.out.print("Range ["+mn+","+mx+"]: ");
                            do {
                                value = C.getInt();
                                if ( (value<mn) || (value>mx) ) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                            while ( (value<mn) || (value>mx) );
                            c = value;
                        }
                        break;
                        case P21:
                        {
                            int value;
                            System.out.println("Player 2 PICK a number");
                            System.out.print("Range ["+mn+","+mx+"]: ");
                            do {
                                value = C.getInt();
                                if ( (value<mn) || (value>mx) ) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                            while ( (value<mn) || (value>mx) );
                            c = value;
                        }
                        break;
                        case PC1:
                            c = mn + rand.nextInt((mx - mn) + 1);
                            break; }
                    C.clearScreen();
                    n = 0;
                    l = mn;
                    u = mx;
                    do {
                        n = n+1;
                        switch (m) {
                            case P21:
                            case PC1:
                            {
                                int value;
                                System.out.println("Player 1 GUESS a number");
                                System.out.print("Range ["+mn+","+mx+"]: ");
                                do {
                                    value = C.getInt();
                                    if ( (value<mn) || (value>mx) ) {
                                        System.out.println("   Value is outside valid range!");
                                        System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                                while ( (value<mn) || (value>mx) );
                                g = value;
                            }
                            break;
                            case P12:
                            {
                                int value;
                                System.out.println("Player 2 GUESS a number");
                                System.out.print("Range ["+mn+","+mx+"]: ");
                                do {
                                    value = C.getInt();
                                    if ( (value<mn) || (value>mx) ) {
                                        System.out.println("   Value is outside valid range!");
                                        System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                                while ( (value<mn) || (value>mx) );
                                g = value;
                            }
                            break;
                            case P1C:
                                switch (lv) {
                                    case 1:
                                        g = mn + rand.nextInt((mx - mn) + 1);
                                        break;
                                    case 2:
                                        g = (l+u)/2;
                                        break;
                                    case 3:
                                        r = (u-l)/3+1;
                                        g = (l+u)/2 + rand.nextInt(r) - r/2;
                                        break; }
                                System.out.println("The computer guesses "+g);
                                break; }
                        if (c < g) {
                            System.out.println("   The guess was too high!");
                            u = g - 1;
                        } else if (c > g) {
                            System.out.println("   The guess was too low!");
                            l = g + 1;
                        } else {
                            System.out.println("   The guess was correct!"); }
                    } while ( c != g );
                    switch (m) {
                        case P21:
                        case PC1:
                            System.out.println("Player 1, it took you "+n+" guesses.");
                            break;
                        case P12:
                            System.out.println("Player 2, it took you "+n+" guesses.");
                            break;
                        case P1C:
                            System.out.println("It took the computer "+n+" guesses.");
                            break; }
                    System.out.println("Press any key to continue...");
                    C.getChar();
                    System.out.println();
                    ga = n;
                }
                {
                    gm m = gm.P21;
                    C.clearScreen();
                    switch (m) {
                        case P12:
                        case P1C:
                        {
                            int value;
                            System.out.println("Player 1 PICK a number");
                            System.out.print("Range ["+mn+","+mx+"]: ");
                            do {
                                value = C.getInt();
                                if ( (value<mn) || (value>mx) ) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                            while ( (value<mn) || (value>mx) );
                            c = value;
                        }
                        break;
                        case P21:
                        {
                            int value;
                            System.out.println("Player 2 PICK a number");
                            System.out.print("Range ["+mn+","+mx+"]: ");
                            do {
                                value = C.getInt();
                                if ( (value<mn) || (value>mx) ) {
                                    System.out.println("   Value is outside valid range!");
                                    System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                            while ( (value<mn) || (value>mx) );
                            c = value;
                        }
                        break;
                        case PC1:
                            c = mn + rand.nextInt((mx - mn) + 1);
                            break; }
                    C.clearScreen();
                    n = 0;
                    l = mn;
                    u = mx;
                    do {
                        n = n+1;
                        switch (m) {
                            case P21:
                            case PC1:
                            {
                                int value;
                                System.out.println("Player 1 GUESS a number");
                                System.out.print("Range ["+mn+","+mx+"]: ");
                                do {
                                    value = C.getInt();
                                    if ( (value<mn) || (value>mx) ) {
                                        System.out.println("   Value is outside valid range!");
                                        System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                                while ( (value<mn) || (value>mx) );
                                g = value;
                            }
                            break;
                            case P12:
                            {
                                int value;
                                System.out.println("Player 2 GUESS a number");
                                System.out.print("Range ["+mn+","+mx+"]: ");
                                do {
                                    value = C.getInt();
                                    if ( (value<mn) || (value>mx) ) {
                                        System.out.println("   Value is outside valid range!");
                                        System.out.print("Reenter value in range ["+mn+","+mx+"]: "); } }
                                while ( (value<mn) || (value>mx) );
                                g = value;
                            }
                            break;
                            case P1C:
                                switch (lv) {
                                    case 1:
                                        g = mn + rand.nextInt((mx - mn) + 1);
                                        break;
                                    case 2:
                                        g = (l+u)/2;
                                        break;
                                    case 3:
                                        r = (u-l)/3+1;
                                        g = (l+u)/2 + rand.nextInt(r) - r/2;
                                        break; }
                                System.out.println("The computer guesses "+g);
                                break; }
                        if (c < g) {
                            System.out.println("   The guess was too high!");
                            u = g - 1;
                        } else if (c > g) {
                            System.out.println("   The guess was too low!");
                            l = g + 1;
                        } else {
                            System.out.println("   The guess was correct!"); }
                    } while ( c != g );
                    switch (m) {
                        case P21:
                        case PC1:
                            System.out.println("Player 1, it took you "+n+" guesses.");
                            break;
                        case P12:
                            System.out.println("Player 2, it took you "+n+" guesses.");
                            break;
                        case P1C:
                            System.out.println("It took the computer "+n+" guesses.");
                            break; }
                    System.out.println("Press any key to continue...");
                    C.getChar();
                    System.out.println();
                    gb = n;
                }
        }
        C.clearScreen();
        if ( ga>gb ) {
        wb++;
        if (cp)
        System.out.println("The computer wins!");
        else
        System.out.println("Player 2 wins!");
        } else if ( ga<gb) {
        wa++;
        System.out.println("Player 1 wins!");
        } else {
        System.out.println("It was a tie!"); }
        System.out.println("Player 1 has won "+wa+" times!");
        if (cp)
        System.out.println("Computer has won "+wb+" times!");
        else
        System.out.println("Player 2 has won "+wb+" times!");
        System.out.print("Play again [Y/N]? ");
        do {
        key = Character.toUpperCase(C.getChar());
        } while ( (key!='N') && (key!='Y') );
        rp = (key=='Y');
        } while (rp);
        System.exit(0);
    }
}
