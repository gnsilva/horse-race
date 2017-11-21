package org.academiadecodigo.horserace.horse;

import static org.academiadecodigo.horserace.constants.Constants.*;

public class Fast extends Horse {


    public Fast(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (distance < FAST_INITIAL_SECTION_DISTANCE) {

            distance += FAST_INITIAL_MIN_SPEED + Math.random() * (FAST_INITIAL_MAX_SPEED - FAST_INITIAL_MIN_SPEED);

        } else if (distance < FAST_CRUISE_SECTION_DISTANCE) {

            distance += FAST_CRUISE_MIN_SPEED + Math.random() * (FAST_CRUISE_MAX_SPEED - FAST_CRUISE_MIN_SPEED);

        } else {

            distance += FAST_FINAL_MIN_SPEED + Math.random() * (FAST_FINAL_MAX_SPEED - FAST_FINAL_MIN_SPEED);
        }
    }

}
