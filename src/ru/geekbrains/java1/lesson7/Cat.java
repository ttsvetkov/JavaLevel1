package ru.geekbrains.java1.lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite = 15;
    private boolean fullness;

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
    public void eat(Plate p) {
        System.out.println("Кот начал есть!");
        p.decreaseFood(appetite);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(){
        this.appetite = random(appetite);
    }

    private int random(int a){
        Random random = new Random();
        return random.nextInt(a) + 1;
    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " по кличке : '" + name + '\'' +
                ((this.fullness) ? "Наелся!!!" : " голодный и хочет съесть = " + + this.appetite + " сосисок" );
    }
}
