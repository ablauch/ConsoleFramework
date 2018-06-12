package javaclasses;


/*
AUTHOR:		Dr. Andrew Blauch
DESCRIPTION:	Lunar Landing Game
FEATURES:
	Play again
*/
public class LunarLanding {
    static MyConsole Console = null;

    /* motion variables */
    private static double x, y, vx, vy, ax, ay, ag, dt, fuel;

    /*
     * This function updates all motion variables
     */
    private static void MotionUpdate()
    {
        x = x + vx*dt + 0.5*ax*dt*dt;
        vx = vx + ax*dt;
        y = y + vy*dt + 0.5*(ay-ag)*dt*dt;
        vy = vy + (ay-ag)*dt;
    }

    /*
    * Main program
     */
    public static void main(String arg[]) {
        char key;
        boolean done;
        int count;

        /* create console object for user input */
        Console = new MyConsole();

        System.out.println("Lunar Landing Game");

        /* initialize motion variables */
        x = 16;
        y = 108;
        vx = 5;
        vy = 0;
        ax = 0;
        ay = 0;
        ag = 3.24;
        dt = 0.1;
        fuel = 60;

        count = 0;
        done = false;
        System.out.println("  x  ,  y    vx  , vy   ax,ay  fuel");

        /* play game */
        do {
            key = Console.checkKey();
            switch (key) {
                case ' ':
                    if (ay==0)
                        ay = 6;
                    else
                        ay = 0;
                    break;
                case ',':
                    if (ax==0)
                        ax = -6;
                    else
                        ax = 0;
                    break;
                case '.':
                    if (ax==0)
                        ax = +6;
                    else
                        ax = 0;
                    break;
                case 'p':
                    break;
                case 'x':
                    done = true;
                    break;
            }

            if (ax<0) {
                if (fuel>0) fuel -= dt;
                else ax = 0;
            }
            if (ax>0) {
                if (fuel>0) fuel -= dt;
                else ax = 0;
            }
            if (ay>0) {
                if (fuel>0) fuel -= dt;
                else ay = 0;
            }

            MotionUpdate();

            /* Display status */
            if (count==0) {
                count = 1;
                System.out.printf("\r%5.1f,%5.1f %5.1f,%5.1f %2.0f,%2.0f   %2.0f",x,y,vx,vy,ax,ay,fuel);
            }
            count--;

            /* check if game is done */
            if ((y<0)||(y>120)||(x<0)||(x>160))
                done = true;

        } while ( !done );

        System.out.println("");
        if (key=='x') {
            System.out.println("Game aborted");
        } else {
            if ((y>120)||(x<0)||(x>160)) {
                System.out.println("You missed the landing site!");
            } else {
                if (vy<-5) {
                    System.out.println("You crashed!!");
                } else {
                    System.out.println("Successful landing!!");
                }
            }
        }

        System.exit(0);
    }
}
