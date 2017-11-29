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
        screen.startScreen();
    }



    /**
     * Displays a group of horses in the screen
     *
     * @param horses an array of horses
     */
    public static void draw(Horse[] horses) {

        screen.clear();

        rowTrack = 10;

        for (Horse horse : horses) {

            screenWriter.drawString((int) horse.getDistance(), horse.getTrack() + rowTrack, horse.toString());
            rowTrack += 2;
        }

        screen.refresh();
    }

    public static void drawRace(Horse[] horses) {

        screen.clear();

        rowTrack = 10;

        for (Horse horse : horses) {

            screenWriter.drawString((int) horse.getDistance(), horse.getTrack() + rowTrack, horse.toString());
            rowTrack += 2;
        }

        screen.refresh();
    }

    public static void drawFinalPositions(Horse[] horses) {

        screen.clear();

        screen.putString((int) horses[0].getDistance(), horses[0].getTrack() * 3 + 10, horses[0].toString(), Terminal.Color.WHITE, Terminal.Color.YELLOW, ScreenCharacterStyle.Blinking);
        screen.putString((int) horses[1].getDistance(), horses[1].getTrack() * 3 + 10, horses[1].toString(), Terminal.Color.WHITE, Terminal.Color.GREEN, ScreenCharacterStyle.Blinking);
        screen.putString((int) horses[2].getDistance(), horses[2].getTrack() * 3 + 10, horses[2].toString(), Terminal.Color.WHITE, Terminal.Color.MAGENTA, ScreenCharacterStyle.Blinking);

        for (int i = 3; i < horses.length; i++) {

            screenWriter.drawString((int) horses[i].getDistance(), horses[i].getTrack() * 3 + 10, horses[i].toString());

            }


        screen.refresh();
    }

}
