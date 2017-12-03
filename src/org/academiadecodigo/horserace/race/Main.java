package org.academiadecodigo.horserace.race;


import org.academiadecodigo.horserace.bookmaker.BetSystem;
import org.academiadecodigo.horserace.display.*;
import org.academiadecodigo.horserace.horse.Horse;
import org.academiadecodigo.horserace.horse.HorseFactory;

public class Main {

    public static void main(String[] args) {

        BetSystem betSystem = new BetSystem();

        Arena arena = new Arena(4, 95, betSystem);
        Display display = new VisualSpeaker();
        arena.setDisplay(display);


        Horse[] horses = HorseFactory.createRaceHorses(7);
        arena.race(horses);

    }

}
