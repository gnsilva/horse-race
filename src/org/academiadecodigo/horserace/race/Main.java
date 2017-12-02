package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.display.*;
import org.academiadecodigo.horserace.horse.Horse;
import org.academiadecodigo.horserace.horse.HorseFactory;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena(10, 95);
        Display display = new VisualSpeaker();
        arena.setDisplay(display);

        Horse[] horses = HorseFactory.createRaceHorses(5);
        arena.race(horses);

    }

}
