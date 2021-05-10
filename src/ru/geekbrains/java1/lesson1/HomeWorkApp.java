package ru.geekbrains.java1.lesson1;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords("\n_Orange\n_Banana\n_Apple");

        checkSumSign(1,2);

        printColor(0);

        compareNumbers(3, 3);
    }

    // задача №2
    public static void printThreeWords(String tXt){

        System.out.println(tXt);
    }

    // задача №3
    public static void checkSumSign(int a, int b){

        if ((a + b) >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // задача №4
    public static void printColor(int value) {

        if (value <= 0){
            System.out.println("Красный");
        } else if (value <= 100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // задача №5
    public static void compareNumbers(int a, int b){

        if ( a >= b) System.out.println("a>=b");
        else System.out.println("a<b");
    }
}
