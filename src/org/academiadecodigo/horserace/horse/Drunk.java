package org.academiadecodigo.horserace.horse;

import static org.academiadecodigo.horserace.constants.Constants.*;

public class Drunk extends Horse {


    public Drunk(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (distance < DRUNK_INITIAL_SECTION_DISTANCE) {

            distance += DRUNK_INITIAL_MIN_SPEED + Math.random() * (DRUNK_INITIAL_MAX_SPEED - DRUNK_INITIAL_MIN_SPEED);

        } else if (distance < DRUNK_CRUISE_SECTION_DISTANCE) {

            distance += DRUNK_CRUISE_MIN_SPEED + Math.random() * (DRUNK_CRUISE_MAX_SPEED - DRUNK_CRUISE_MIN_SPEED);

        } else {

            distance += DRUNK_FINAL_MIN_SPEED + Math.random() * (DRUNK_FINAL_MAX_SPEED - DRUNK_FINAL_MIN_SPEED);
        }
    }

}
