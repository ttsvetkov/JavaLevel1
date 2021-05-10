package ru.geekbrains.java1.lesson7;

public class HomeWork7 {

    private static final int CATS = 4; // количество голодных котов
    private static final int PLATE = 4; // кол-во тарелок
    private static final int SOUSAGE = 35; // сколько у нас сосисок в холодильнике

    public static void main(String[] args) {

        Cat[] arrCats = createCats(CATS);
        Plate[] arrPlate = createPlate(PLATE);

        do{
            // кормим котов, перекладываем сосиски
        }while (!catFulness());

    }

    private static boolean catFulness() {
        return true;
    }

    public static Cat[] createCats(int cat) {
        Cat[] arrayCats = new Cat[cat];

        for (int i = 0; i < cat; i++){
            arrayCats[i] = new Cat("Barsik - " + i);
            arrayCats[i].info();
        }
        return arrayCats;
    }

    public static void countApettite(Cat[] arr){

    }

    public static Plate[] createPlate(int plate) {
        Plate[] arrayPlate = new Plate[plate];

        for (int i = 0; i < plate; i++){
            arrayPlate[i] = new Plate();
            arrayPlate[i].info();
        }
        return arrayPlate;
    }
}
