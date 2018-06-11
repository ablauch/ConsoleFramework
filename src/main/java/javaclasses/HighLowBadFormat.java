package javaclasses;
import java.util.Random;
public class HighLowBadFormat {
    static MyConsole C = null;
    static enum gm {P12, P1C, P21, PC1};
    private static int mn =1, mx =10;
    private static int lv =1;
    private static boolean rp =false, c =false, f =true;
    private static int get(String prompt, int min, int max)
    {
        int value;
        System.out.println(prompt);
        System.out.print("Range ["+min+","+max+"]: ");
        do {
        value = C.getInt();
        if ( (value<min) || (value>max) ) {
        System.out.println("   Value is outside valid range!");
        System.out.print("Reenter value in range ["+min+","+max+"]: "); } }
        while ( (value<min) || (value>max) );
        return value;
    }
    private static int play(gm m)
    {
        Random rand = new Random();
        int	c=0, g=0, n=0, l, u, r;
        C.clearScreen();
        switch (m) {
        case P12:
        case P1C:
        c = get("Player 1 PICK a number", mn, mx);
        break;
        case P21:
        c = get("Player 2 PICK a number", mn, mx);
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
        g = get("Player 1 GUESS a number", mn, mx);
        break;
        case P12:
        g = get("Player 2 GUESS a number", mn, mx);
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
        return n;
    }
    private static void settings()
    {
        char key;
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
        c = (key=='Y');
        System.out.println();
        if (c) {
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
        if (c) {
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
    }
    public static void main(String arg[]) {
        char key;
        int	ga, gb;
        int	wa, wb;
        C = new MyConsole();
        System.out.println("High Low Guessing Game");
        settings();
        wa = 0;
        wb = 0;
        do {
        if (c) {
        if (f) {
        gb = play(gm.P1C);
        ga = play(gm.PC1);
        } else {
        ga = play(gm.PC1);
        gb = play(gm.P1C); }
        } else {
        ga = play(gm.P12);
        gb = play(gm.P21); }
        C.clearScreen();
        if ( ga>gb ) {
        wb++;
        if (c)
        System.out.println("The computer wins!");
        else
        System.out.println("Player 2 wins!");
        } else if ( ga<gb) {
        wa++;
        System.out.println("Player 1 wins!");
        } else {
        System.out.println("It was a tie!"); }
        System.out.println("Player 1 has won "+wa+" times!");
        if (c)
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
