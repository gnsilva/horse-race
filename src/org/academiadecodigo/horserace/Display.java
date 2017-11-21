package org.academiadecodigo.horserace;

import org.academiadecodigo.horserace.horse.Horse;

public interface Display {

    void render(Horse[] horses);

    void announceWinner(Horse winner);
}
