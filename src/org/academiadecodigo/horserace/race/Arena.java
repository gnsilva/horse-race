package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.horse.Drunk;
import org.academiadecodigo.horserace.horse.Fast;
import org.academiadecodigo.horserace.horse.Horse;
import org.academiadecodigo.horserace.horse.Slow;

public class Arena {

    private int trackDistance;
    private int numberOfTracks;
    private Horse[] horses;
    private Speaker speaker;


    public Arena(int numberOfTracks, int trackDistance) {

        this.numberOfTracks = numberOfTracks;
        this.trackDistance = trackDistance;

        speaker = new Speaker();
    }


    public void init() {

        createRaceHorces(numberOfTracks);

        while (noWinner()) {

            race();
            speaker.comment(horses);
        }

        Horse winner = this.getWinner();
        speaker.announceWinner(winner);

    }

    private Horse getWinner() {

        Horse winner = null;
        double longerDistance = 0;

        for (int i = 0; i < horses.length; i++) {

            if (horses[i].getDistance() > longerDistance) {

                longerDistance = horses[i].getDistance();
                winner = horses[i];
            }
        }

        return winner;
    }

    private void race() {

        for (Horse horse : horses) {

            horse.run();
            //System.out.println("Track " + horse.getTrack() + " - " + horse.getName() + " distance is " + horse.getDistance());
        }
    }


    public boolean noWinner() {

        for (Horse horse : horses) {

            if (horse.getDistance() >= trackDistance) {

                return false;
            }
        }

        return true;
    }

    public Horse[] createRaceHorces(int arenaTracks) {

        String[] championshipHorses = {"Pizza", "Beer", "Sócio", "Bull Balls", "Dirty Harry", "Apache", "BBQ", "Billy the Kid",
                "HangMan", "Jalapeño", "Rambo", "Xtreme", "Victory"};

        horses = new Horse[arenaTracks];


        for (int i = 0; i < arenaTracks; i++) {

            double randomHorseType = Math.random();

            if (randomHorseType < 0.33) {

                horses[i] = new Fast(championshipHorses[i]);

            } else if (randomHorseType > 0.66) {

                horses[i] = new Slow(championshipHorses[i]);

            } else {

                horses[i] = new Drunk(championshipHorses[i]);
            }

            horses[i].setTrack(i);
        }

        return horses;
    }

}
