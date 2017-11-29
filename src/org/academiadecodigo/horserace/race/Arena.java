package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.display.Display;
import org.academiadecodigo.horserace.horse.*;

public class Arena {

    private int trackDistance;
    private int numberOfTracks;
    private Horse[] horses;
    private Horse[] finalRacePositions;

    private Display display;


    public Arena(int numberOfTracks, int trackDistance) {

        this.numberOfTracks = numberOfTracks;
        this.trackDistance = trackDistance;
    }


    public void init() {

        horses = HorseFactory.createRaceHorces(numberOfTracks);
        finalRacePositions = new Horse[numberOfTracks];

        display.initialRender(horses);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!lastHorseHasFinished()) {

            race();

            display.render(horses);

        }

        // Horse winner = this.getWinner();
        display.finalRender(getFirstPlace());
    }


    private Horse getFirstPlace() {

        Horse firstPlace = null;

        for (Horse horse : horses) {

            if (horse.getDistance() >= trackDistance) {

                firstPlace = horse;
            }
        }

        return firstPlace;
    }


    public boolean hasFinished(Horse horse) {

        for (int i = 0; i < finalRacePositions.length; i++) {

            if (horse.equals(finalRacePositions[i])) {
                return true;
            }
        }

        return false;
    }


    private void race() {

        for (Horse horse : horses) {

            horse.run();

            if (horse.getDistance() >= trackDistance) {

                horse.setDistance(trackDistance);
            }
            System.out.println("Track " + horse.getTrack() + " - " + horse.getName() + " distance is " + horse.getDistance());
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

    private boolean lastHorseHasFinished() {

        int horsesFinished = 0;

        for (Horse horse : horses) {

            if (horse.getDistance() >= trackDistance) {
                horsesFinished += 1;
            }
        }

        return horsesFinished >= horses.length;
    }


    public void setDisplay(Display display) {
        this.display = display;
    }
}
