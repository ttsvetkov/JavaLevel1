package ru.geekbrains.java1.lesson7;

import java.util.Scanner;

public class HomeWork7 {

    private static final int CATS = 8; // количество голодных котов
    private static final int PLATE = 2; // кол-во тарелок
    private static final int SOUSAGE = 35; // сколько у нас сосисок в холодильнике
    private static int sousageBuff= 0; // сколько осталось у нас сосисок в холодильнике

    public static void main(String[] args) {

        Cat[] arrCats = createCats(CATS);
        Plate[] arrPlate = createPlate(PLATE, SOUSAGE);

        eat(arrCats, arrPlate);

        while (true){
            if (checkFullness(arrCats) == 1) {
                System.out.println("\n ВСЕ КОТЫ НАКОРМЛЕНы!!!");
                checkPlate(arrPlate);
                break;
            } else {
                System.out.println("\n" + checkFullness(arrCats) + " барсика еще голодные!!!" + " Но в холодильнике осталось: " + sousageBuff);
                System.out.println("Добавить сосисок в тарелки? 1 - да, 2 - нет");

                Scanner scanner = new Scanner(System.in);
                int sc = scanner.nextInt();

                if(sc == 1){
                    refullPlate(arrPlate, sousageBuff);
                    checkPlate(arrPlate);
                    eat(arrCats, arrPlate);
                } else {
                    System.out.println("cats dead");
                    break;
                }
            }
        }

    }

    private static void eat(Cat[] arrCats, Plate[] arrPlate) {
        for (Cat arrCat : arrCats) {
            for (Plate plate : arrPlate) {
                if (!arrCat.getFullness()) {
                    checkEat(arrCat, plate);
                }
            }
        }
    }

    private static void refullPlate(Plate[] plates, int sousage) {

            for (Plate p: plates){
                if(sousageBuff > 0){
                    sousageBuff -= p.getFood();
                    p.addFood(sousage);
                }
            }
    }

    private static int checkFullness(Cat[] cats){
        int count = 0;
        for (Cat cat : cats){
            if (cat.getFullness()) count++;
        }
        if (cats.length == count) {
            return 1;
        }else return (cats.length - count);
    }

    private static void checkPlate(Plate[] plates){
        for (Plate plate : plates){
                plate.info();
        }
    }

    private static void checkEat(Cat cat, Plate plate){

        int catAppetite = cat.getAppetite();
        int plateFood = plate.getFood();

        if (checkFullPlate(cat, plate)){
            cat.decreaseAppetite(plateFood);
            plate.decreaseFood(catAppetite);
            cat.setFullness(true);
            System.out.println();
            System.out.printf( "%s поел из %d тарелки, и теперь сытый!", cat.getName(), plate.getNumberPlate());
        } else if (checkPartPlate(cat, plate)){
            cat.decreaseAppetite(catAppetite);
            cat.setFullness(true);
            plate.decreaseFood(catAppetite);
            System.out.println();
            System.out.printf( "%s поел из %d тарелки, и теперь сытый!", cat.getName(), plate.getNumberPlate());
        } else if (!checkFullPlate(cat, plate) && !checkPartPlate(cat, plate)){
            System.out.println();
            System.out.printf( "%s не стал есть из %d тарелки, и всё еще голодный", cat.getName(), plate.getNumberPlate());
//            System.out.printf("В тарелке %d мало (%d) сосисок для %s", plate.getNumberPlate(),plate.getFood(),cat.getName());
        }
    }

    private static boolean checkFullPlate(Cat cat, Plate plate) {
        if (!cat.getFullness() && plate.getFood() != 0){
            return cat.getAppetite() == plate.getFood();
        } else return false;
    }

    private static boolean checkPartPlate(Cat cat, Plate plate) {
        if (!cat.getFullness() && plate.getFood() != 0){
            return cat.getAppetite() < plate.getFood();
        } else return false;
    }

    public static Cat[] createCats(int cat) {
        Cat[] arrayCats = new Cat[cat];
        System.out.println("Прибежало " + cat + " голодных кота(-ов)");
        for (int i = 0; i < cat; i++){
            arrayCats[i] = new Cat("Barsik " + i);
            arrayCats[i].info();
        }
        return arrayCats;
    }

    public static Plate[] createPlate(int plate, int sousage) {
        Plate[] arrayPlate = new Plate[plate];
        System.out.println("\n Оказалось всего " + plate + " тарелки с сосисками");

        do {
            sousageBuff = 0;
            Plate.countPlate = 0;                 // не очень нравиться. но лучше не придумал
            for (int i = 0; i < plate; i++) {
                arrayPlate[i] = new Plate();
                arrayPlate[i].info();
                sousageBuff += arrayPlate[i].getFood();
            }
        }while (sousageBuff > sousage);

        sousageBuff = sousage - sousageBuff;
        System.out.println(" В холодильнике осталось : " + sousageBuff + "сосисок");
        return arrayPlate;
    }
}
