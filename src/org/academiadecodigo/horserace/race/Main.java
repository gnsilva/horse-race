package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.display.*;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena(5, 100);

        Display display = new DisplayLanterna();

        arena.setDisplay(display);

        arena.init();
    }

}
