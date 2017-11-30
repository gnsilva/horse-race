package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.display.*;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena(5, 95);

        Display display = new VisualSpeaker();

        arena.setDisplay(display);

        arena.init();
    }

}
