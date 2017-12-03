package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.bookmaker.BetSystem;
import org.academiadecodigo.horserace.display.Display;
import org.academiadecodigo.horserace.horse.*;

import java.util.*;

public class Arena {

    private int trackDistance;
    private int numberOfTracks; // TODO: cant have more horses than number of tracks (FIX ME)
    private BetSystem betSystem;

    private Display display;


    public Arena(int numberOfTracks, int trackDistance, BetSystem betSystem) {

        this.numberOfTracks = numberOfTracks;
        this.trackDistance = trackDistance;
        this.betSystem = betSystem; // TODO: make this come from main
    }


    public void race(Horse[] horses) {

        Horse[] horsesRunning = checkIfHorsesFitArenaSize(horses);

        placeBets(horsesRunning); // blocking

        Set<Horse> ranking = new LinkedHashSet<>();
        announce(horsesRunning);
        sleep(1000);

        while (ranking.size() < horsesRunning.length) {
            raceStep(horsesRunning);
            display.render(horsesRunning);

            for (Horse h : findFinishers(horsesRunning)) {
                ranking.add(h);
            }

            sleep(500);
        }

        // converting set to array for compatibility reasons. toArray inserts all the elements in the specified array
        // and returns it with all the elements inserted
        display.finalRender(ranking.toArray(new Horse[ranking.size()]));

    }


    private void placeBets(Horse[] horses) {
        betSystem.startBets(horses);
    }


    private void raceStep(Horse[] horses) {

        for (Horse horse : horses) {
            horse.run();

            if (horse.getDistance() >= this.trackDistance) {
                horse.setDistance(this.trackDistance);
            }

            //System.out.println("Track " + horse.getTrack() + " - " + horse.getName() + " distance is " + horse.getDistance());
        }
    }


    private List<Horse> findFinishers(Horse[] horses) {

        List<Horse> finishers = new LinkedList<>();

        for (Horse h : horses) {

            if (h.getDistance() >= this.trackDistance) {
                finishers.add(h);
            }
        }

        return finishers;
    }

    private Horse[] checkIfHorsesFitArenaSize(Horse[] horses) {

        if (horses.length > numberOfTracks) {

            Horse[] lessHorses = new Horse[numberOfTracks];

            for (int i = 0; i < lessHorses.length; i++) {

                lessHorses[i] = horses[i];
            }

            return lessHorses;
        }

        return horses;
    }


    private void announce(Horse[] horses) {
        display.initialRender(horses);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setDisplay(Display display) {
        this.display = display;
    }
}
