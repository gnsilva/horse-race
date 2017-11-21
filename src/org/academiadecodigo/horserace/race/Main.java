package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.Display;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena(4, 100);

        Display display = new Speaker();

        arena.setDisplay(display);

        arena.init();
    }

}
