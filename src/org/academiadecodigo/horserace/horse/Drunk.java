package org.academiadecodigo.horserace.horse;

public class Drunk extends Horse {


    public Drunk(String name) {
        super(name);
    }

    @Override
    public void run() {

        distance += (Math.random() * 4);
    }

}
