package ru.geekbrains.java1.lesson6;

import java.util.Random;

public class Cat extends Animal{

    public static int count = 0;
    private static final boolean RUN = true;
    private static final int RUN_DIST = 200;
    private static final boolean SWIM = false;
    private static final int SWIM_DIST = 200;

    public Cat(String name, boolean run, int distRun, boolean swim, int distSwim) {
        super(name, run, distRun, swim, distSwim);
        this.distRun = RUN_DIST;
        this.swim = false;
        count++;
    }
    public Cat(String name){

        super(name, RUN, RUN_DIST, SWIM, SWIM_DIST);
        count++;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }


}
