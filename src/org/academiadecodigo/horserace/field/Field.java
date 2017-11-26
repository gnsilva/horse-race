package org.academiadecodigo.horserace.field;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.horserace.horse.Horse;

public final class Field {

    public static int width;
    public static int height;
    public static int rowTrack;

    // Used to write to screen
    private static Screen screen;

    // Screen wrapper that preserves default options
    private static ScreenWriter screenWriter;

    //This class is not supposed to be instantiated
    private Field() {
    }

    /**
     * Initializes the Screen
     *
     * @param width  screen width
     * @param height screen height
     */
    public static void init(int width, int height) {

        // Create the GUI
        screen = TerminalFacade.createScreen();

        // Set field size
        Field.width = width;
        Field.height = height;
        screen.getTerminal().setCursorVisible(false); // Not Working
        screen.getTerminal().getTerminalSize().setColumns(width);
        screen.getTerminal().getTerminalSize().setRows(height);

        // Default screen writing options
        screenWriter = new ScreenWriter(screen);
        screenWriter.setBackgroundColor(Terminal.Color.BLUE);
        screenWriter.setForegroundColor(Terminal.Color.WHITE);
        System.out.println("init screen");
        screen.startScreen();
        System.out.println("init startscreen");

    }

    /**
     * Displays a group of horses in the screen
     *
     * @param horses an array of horses
     */
    public static void draw(Horse[] horses) {

        screen.clear();

        for (Horse horse : horses) {

            rowTrack = horse.getTrack() + 10;

            screenWriter.drawString((int) horse.getDistance(), rowTrack, horse.toString());

            rowTrack += 3;
        }

        screen.refresh();
    }

    public static void drawRace(Horse horse) {

        screenWriter.drawString((int) horse.getDistance(), rowTrack, horse.toString());
    }

    public static void drawWinner(Horse horse) {

        screen.putString((int)horse.getDistance(), rowTrack, horse.toString(), Terminal.Color.WHITE, Terminal.Color.RED, ScreenCharacterStyle.Blinking);

    }

}
