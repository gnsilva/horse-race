package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.display.Display;
import org.academiadecodigo.horserace.horse.*;

public class Arena {

    private int trackDistance;
    private int numberOfTracks;
    private boolean ended;
    private Horse[] horses;
    private Horse[] finishLine;

    private Display display;


    public Arena(int numberOfTracks, int trackDistance) {

        this.numberOfTracks = numberOfTracks;
        this.trackDistance = trackDistance;
    }


    public void init() {

        horses = HorseFactory.createRaceHorses(numberOfTracks);
        finishLine = new Horse[numberOfTracks];

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

        display.finalRender(finishLine);
    }


    private void race() {

        for (Horse horse : horses) {

            ended = hasFinished(horse);

            horse.run();

            buildFinishLine(horse);

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


    private void buildFinishLine(Horse horse) {

        if (horse.getDistance() >= trackDistance) {

            horse.setDistance(trackDistance);

            if (!ended) {

                for (int i = 0; i < finishLine.length; i++) {

                    if (finishLine[i] == null) {

                        finishLine[i] = horse;
                        break;
                    }
                }
            }
        }
    }


    private boolean hasFinished(Horse horse) {
        return horse.getDistance() >= trackDistance;
    }


    public void setDisplay(Display display) {
        this.display = display;
    }
}
