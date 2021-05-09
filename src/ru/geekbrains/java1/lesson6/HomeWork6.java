package ru.geekbrains.java1.lesson6;

import java.util.Random;
import java.util.Scanner;

public class HomeWork6 {

    private static Animal[] animalsCats;
    private static Animal[] animalsDogs;

    public static void main(String[] args) {

        System.out.println("Введите максимальное кол-во животных: ");
        Scanner scanner = new Scanner(System.in);
        int animals= scanner.nextInt();

        createAnimals(animals);

        actionAnimals(animalsCats);
        actionAnimals(animalsDogs);

        System.out.println();
        System.out.println("Котов было создано: " + Cat.count);
        System.out.println("Собак было создано: " + Dog.count);
        System.out.println("Всего животных: " + Animal.count);

    }

    private static void createAnimals(int animals){
        Random random = new Random();
        int cat;
        int dog;
        do{
           cat = random.nextInt(animals);
           dog = random.nextInt(animals);
        }while (animals != (cat + dog));

        animalsCats = createCats(cat);
        animalsDogs = createDog(dog);
    }

    private static Animal[] createDog(int dog) {
        Animal[] arrayDog = new Animal[dog];
        for (int i = 0; i < dog; i++){
            arrayDog[i] = new Dog("Собака-" + (i + 1));
        }
        return arrayDog;
    }

    private static Animal[] createCats(int cat) {
        Animal[] arrayCats = new Animal[cat];
        for (int i = 0; i < cat; i++){
            arrayCats[i] = new Cat("Кот-" + (i + 1));
        }
        return arrayCats;
    }

    private static void actionAnimals(Animal[] arr){
        for (int i = 0; i <= arr.length - 1; i++){
            System.out.println(arr[i].run() + " и " + arr[i].swim());
        }
    }
}
