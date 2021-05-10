package ru.geekbrains.java1.lesson7;

import java.util.Random;

public class Plate {

    private int maxFood = 10; // сколько сосисок поместиться в одну тарелку

    public Plate() {

        this.setFood(maxFood);
    }

    public void info() {

        System.out.println("В тарелке: " + maxFood + " сосисок");
    }

    public void decreaseFood(int amount) {

        maxFood -= amount;
    }

    public int getFood() {

        return maxFood;
    }

    public void setFood(int maxFood) {

        this.maxFood = random(maxFood); // произвольно раскидываем сосиски по тарелкам
    }

    private int random(int a){
        Random random = new Random();
        return random.nextInt(a) + 1;
    }
}
