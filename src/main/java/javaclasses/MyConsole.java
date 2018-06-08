package javaclasses;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyConsole {
    private KeyEvent lastevent = null;

    public MyConsole() {
        KeyListener listener = new MyListener();

        JFrame frame = new JFrame("MyConsole");
        Container contentPane = frame.getContentPane();
        JTextField textField = new JTextField();
        textField.addKeyListener(listener);
        contentPane.add(textField, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    public final void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public char getKey() {
        return getKey(false);
    }

    public char getKey(boolean echo) {
        sleep(100);
        if (lastevent==null)
            return 0;
        char key = lastevent.getKeyChar();
        lastevent = null;
        if (echo)
            System.out.print(key);
        return key;
    }

    public int getInt() {
        char key;
        int number = 0;

        do {
            key = getKey();
            switch (key) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    System.out.print(key);
                    number = number*10 + (int)(key-'0');
                    break;
                case 10:
                    System.out.print(key);
                    break;
                default:
                    break;
            }
        } while (key!=10);

        return number;
    }

    /*
        KeyListener class
        This object 'listens' for a key to be pressed and records event for use by console object
     */
    private class MyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent event) {
            char key = event.getKeyChar();

            // determine if valid key (limit what is processed)
            if ( Character.isLetterOrDigit(key) || (key==10) ) {
                lastevent = event;
            }

            // prevent key from being displayed in text frame
            event.consume();

            // display debug information about event
//            printEventInfo("Key Pressed", event);
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }

        @Override
        public void keyTyped(KeyEvent event) {
            // prevent key from being displayed in text frame
            event.consume();
        }

        /*
            Methods to display debug information about event
         */
        private void printEventInfo(String str, KeyEvent e) {
            System.out.println(str);
            int code = e.getKeyCode();
            System.out.println("   Code: " + code);
            System.out.println("   Code: " + KeyEvent.getKeyText(code));
            System.out.println("   Char: " + e.getKeyChar());
            int mods = e.getModifiersEx();
            System.out.println("    Mods: "
                    + KeyEvent.getModifiersExText(mods));
            System.out.println("    Location: "
                    + keyboardLocation(e.getKeyLocation()));
            System.out.println("    Action? " + e.isActionKey());
            System.out.println("isDigit       "+Character.isDigit(e.getKeyChar()));
            System.out.println("isLetter      "+Character.isLetter(e.getKeyChar()));
            System.out.println("isLetterDigit "+Character.isLetterOrDigit(e.getKeyChar()));
        }

        private String keyboardLocation(int keybrd) {
            switch (keybrd) {
                case KeyEvent.KEY_LOCATION_RIGHT:
                    return "Right";
                case KeyEvent.KEY_LOCATION_LEFT:
                    return "Left";
                case KeyEvent.KEY_LOCATION_NUMPAD:
                    return "NumPad";
                case KeyEvent.KEY_LOCATION_STANDARD:
                    return "Standard";
                case KeyEvent.KEY_LOCATION_UNKNOWN:
                default:
                    return "Unknown";
            }
        }
    }
}
