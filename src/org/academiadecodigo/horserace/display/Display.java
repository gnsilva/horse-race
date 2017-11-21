package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.horse.Horse;

public interface Display {

    void initialRender(Horse[] horses);

    void render(Horse[] horses);

    void finalRender(Horse winner);
}
