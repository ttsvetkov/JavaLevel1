package ru.geekbrains.java1.lesson6;

import java.util.Random;

public abstract class Animal {

    protected String name;
    protected boolean run;
    protected int distRun;
    protected boolean swim;
    protected int distSwim;
    public static int count = 0;

    public Animal(String name, boolean run, int distRun, boolean swim, int distSwim){
        this.run = run;
        this.distRun = distRun;
        this.swim = swim;
        this.distSwim = distSwim;
        this.name = name;
        count++;
    }

    public String run(){
        if(this.run) {
            return ( /*this.getClass() + " по имени " + */
                    this.getName() + " пробежал: " + getDistRun(this.distRun) + " метра(ов) ");
        }else {
            return (/*this.getClass() + " по имени " + */
                    this.getName() +" не бегает ");
        }
    }

    public String swim(){
        if(this.swim) {
            return (/*this.getClass()+" по имени " +*/
                    this.getName() + " проплыло: " + getDistSwim(this.distSwim) + " метра(ов) ");
        }else {
            return (/*this.getClass() + " по имени " +*/
                    this.getName() + " не умеет плавать ");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistRun(int distRun) {
        return random(this.distRun);
    }

    public int getDistSwim(int distSwim) {
        return random(distSwim);
    }

    private int random(int a){
        Random random = new Random();
        return random.nextInt(a) + 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setDistRun(int distRun) {
        this.distRun = distRun;
    }

    public void setSwim(boolean swim) {
        this.swim = swim;
    }

    public void setDistSwim(int distSwim) {
        this.distSwim = distSwim;
    }
}
