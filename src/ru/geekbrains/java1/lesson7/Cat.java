package ru.geekbrains.java1.lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite = 10; // максимально возможный аппетит у котов
    private boolean fullness;  // голод

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }
    public Cat(String name) {
        this.name = name;
        this.setAppetite();
        this.fullness = false;
    }

    public void decreaseAppetite(int amount) {

        this.appetite -= amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int a){
        this.appetite = a;
    }

    public void setAppetite(){
        this.appetite = random(appetite);
    }

    private int random(int a){
        Random random = new Random();
        return random.nextInt(a) + 1;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public int getAppetite() {
        return this.appetite;
    }

    public boolean getFullness() {
        return this.fullness;
    }

    public String getName() {
        return name;
    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " по кличке : '" + name + '\'' +
                ((this.fullness) ? "Накормлен" : " голодный и хочет съесть = " + + this.appetite + " сосисок" );
    }

}
