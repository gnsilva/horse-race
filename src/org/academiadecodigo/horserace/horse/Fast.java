package org.academiadecodigo.horserace.horse;

public class Fast extends Horse {


    public Fast(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (distance < 20) {

            distance += 3;

        } else if (distance < 80) {

            distance += 2;

        } else {

            distance += 3;
        }
    }

}
