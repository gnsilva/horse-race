package org.academiadecodigo.horserace.horse;


import static org.academiadecodigo.horserace.constants.Constants.*;

public class Slow extends Horse {


    public Slow(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (distance < SLOW_INITIAL_SECTION_DISTANCE) {

            distance += SLOW_INITIAL_MIN_SPEED + Math.random() * (SLOW_INITIAL_MAX_SPEED - SLOW_INITIAL_MIN_SPEED);

        } else if (distance < SLOW_CRUISE_SECTION_DISTANCE) {

            distance += SLOW_CRUISE_MIN_SPEED + Math.random() * (SLOW_CRUISE_MAX_SPEED - SLOW_CRUISE_MIN_SPEED);

        } else {

            distance += SLOW_FINAL_MIN_SPEED + Math.random() * (SLOW_FINAL_MAX_SPEED - SLOW_FINAL_MIN_SPEED);
        }
    }

    @Override
    public String toString() {
        return getName().substring(0,1);
    }

}
