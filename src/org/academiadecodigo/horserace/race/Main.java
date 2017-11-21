package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.display.Display;
import org.academiadecodigo.horserace.display.Speaker;
import org.academiadecodigo.horserace.display.VisualSpeaker;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena(5, 100);

        Display display = new VisualSpeaker();

        arena.setDisplay(display);

        arena.init();
    }

}
