package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.display.Display;
import org.academiadecodigo.horserace.horse.*;

public class Arena {

    private int trackDistance;
    private int numberOfTracks;
    private Horse[] horses;

    private Display display;


    public Arena(int numberOfTracks, int trackDistance) {

        this.numberOfTracks = numberOfTracks;
        this.trackDistance = trackDistance;

    }


    public void init() {

        horses = HorseFactory.createRaceHorces(numberOfTracks);

        display.initialRender(horses);

        while (noWinner()) {

            race();

            display.render(horses);
        }

        // Horse winner = this.getWinner();
        display.finalRender(getWinner());
    }


    private Horse getWinner() {

        Horse winner = null;
        double longerDistance = 0;

        for (Horse horse : horses) {

            if (horse.getDistance() > longerDistance) {

                longerDistance = horse.getDistance();
                winner = horse;
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


    private boolean noWinner() {

        for (Horse horse : horses) {

            if (horse.getDistance() >= trackDistance) {

                return false;
            }
        }

        return true;
    }


    public void setDisplay(Display display) {
        this.display = display;
    }
}
