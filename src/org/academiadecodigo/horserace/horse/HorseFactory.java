package org.academiadecodigo.horserace.horse;

public class HorseFactory {




    public static Horse[] createRaceHorces(int arenaTracks) {

        String[] championshipHorses = {"Pizza", "Beer", "Sócio", "Bull Balls", "Dirty Harry", "Apache", "BBQ", "Billy the Kid",
                "HangMan", "Jalapeño", "Rambo", "Xtreme", "Victory"};

        Horse[] horses = new Horse[arenaTracks];


        for (int i = 0; i < arenaTracks; i++) {

            double randomHorseType = Math.random();

            if (randomHorseType < 0.33) {

                horses[i] = new Fast(championshipHorses[i]);
                System.out.println(horses[i].getName() + " is a Fast horse");

            } else if (randomHorseType < 0.66) {

                horses[i] = new Slow(championshipHorses[i]);
                System.out.println(horses[i].getName() + " is a Slow horse");

            } else {

                horses[i] = new Drunk(championshipHorses[i]);
                System.out.println(horses[i].getName() + " is a Drunk horse");
            }

            horses[i].setTrack(i);
        }

        return horses;
    }

}


