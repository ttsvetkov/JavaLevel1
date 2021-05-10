package ru.geekbrains.java1.lesson6;

import java.util.Random;

public class Dog extends Animal{

    public static int count = 0;
    private static final boolean RUN = true;
    private static final int RUN_DIST = 500;
    private static final boolean SWIM = true;
    private static final int SWIM_DIST = 10;

    public Dog(String name, boolean run, int distRun, boolean swim, int distSwim) {
        super(name, run, distRun, swim, distSwim);
        count++;
    }

    public Dog(String name){

        super(name, RUN, RUN_DIST, SWIM, SWIM_DIST);
        count++;
    }

// переопределил методы из-за падежей в сообщениях, можно было бы отфильтровать по вызываемому классу, и оставить всё в родительском классе

    public String run(){
        if(this.run) {
            return (/*this.getClass() + " по имени " + */
                    this.getName() + " пробежала: " + getDistRun(this.distRun) + " метра(ов) ");
        }else {
            return (/*this.getClass() + " по имени " + */
                    this.getName() +" не бегает ");
        }
    }

    public String swim(){
        if(this.swim) {
            return(/*this.getClass()+" по имени " +*/
                     " проплыла: " + getDistSwim(this.distSwim) + " метра(ов) ");
        }else {
            return (/*this.getClass() + " по имени " +*/
                     " не умеет плавать ");
        }
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + '}';
    }
}
