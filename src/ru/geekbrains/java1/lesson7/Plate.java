package ru.geekbrains.java1.lesson7;

import java.util.Random;

public class Plate {

    private int food;
    private int number;
    private final int maxFood = 10; // сколько сосисок поместиться в одну тарелку
    public static int countPlate = 0;

    public Plate() {
        countPlate++;
        this.setNumber(countPlate);
        this.setFood(maxFood);
    }

    public int getNumberPlate() {
        return this.number;
    }

    public void info() {

        System.out.printf("В тарелке №-%d = " + this.getFood() + " сосисок", this.getNumberPlate());
        System.out.println();
    }

    public void decreaseFood(int amount) {

        this.food -= amount;
    }

    public void addFood(int amount) {
        if ((this.food + amount) > maxFood){
            this.food = maxFood;
        } else{
            this.food += amount;
        }

    }

    public int getFood() {

        return this.food;
    }

    public void setNumber(int i){

        this.number = i;
    }

    public void setFood(int maxFood) {

        this.food = random(maxFood); // произвольно раскидываем сосиски по тарелкам
    }

    private int random(int a){
        Random random = new Random();
        return random.nextInt(a) + 1;
    }
}
