package org.academiadecodigo.horserace.horse;

import java.util.Map;

public abstract class Horse{

    private String name;
    protected double distance = 0;
    private int track;


    public Horse(String name) {

        this.name = name;
    }


    public abstract void run();


    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }


}
