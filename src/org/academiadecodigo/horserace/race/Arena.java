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

        horses = HorseFactory.createRaceHorses(numberOfTracks);
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

        display.finalRender(finalRacePositions);
    }


    private void race() {

        for (Horse horse : horses) {

            boolean ended = hasFinished(horse);

            horse.run();

            if (horse.getDistance() >= trackDistance) {

                if (!ended) {

                    horse.setDistance(trackDistance);

                    for (int i = 0; i < finalRacePositions.length; i++) {

                        if (finalRacePositions[i] == null) {

                            finalRacePositions[i] = horse;
                            break;
                        }
                    }

                } else {

                    horse.setDistance(trackDistance);
                }
            }

            //System.out.println("Track " + horse.getTrack() + " - " + horse.getName() + " distance is " + horse.getDistance());
        }
    }


    private boolean lastHorseHasFinished() {

        int horsesFinished = 0;

        for (Horse horse : horses) {

            if (hasFinished(horse)) {
                horsesFinished += 1;
            }
        }

        return horsesFinished >= horses.length;
    }


    private boolean hasFinished(Horse horse) {
        return horse.getDistance() >= trackDistance;
    }


    public void setDisplay(Display display) {
        this.display = display;
    }
}
