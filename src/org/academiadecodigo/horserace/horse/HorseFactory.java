package org.academiadecodigo.horserace.horse;

public class HorseFactory {


    public static Horse[] createRaceHorses(int chooseNumberOfHorses) {

        String[] championshipHorses = {"Pizza", "Beer", "Sócio", "Bull Balls", "Dirty Harry", "Apache", "BBQ", "Billy the Kid",
                "HangMan", "Jalapeño", "Rambo", "Xtreme", "Victory"};


        Horse[] horses = new Horse[chooseNumberOfHorses];


        for (int i = 0; i < chooseNumberOfHorses; i++) {

            double randomHorseType = Math.random();

            if (randomHorseType < 0.33) {

                horses[i] = new Fast(championshipHorses[i]);

            } else if (randomHorseType < 0.66) {

                horses[i] = new Slow(championshipHorses[i]);

            } else {

                horses[i] = new Drunk(championshipHorses[i]);
            }

            horses[i].setTrack(i + 1);
        }

        return horses;
    }

}