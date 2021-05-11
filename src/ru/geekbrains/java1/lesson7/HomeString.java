package ru.geekbrains.java1.lesson7;

//         a) Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
//         б) Распечатать последний символ строки. Используем метод String.charAt().
//         в) Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
//         г) Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
//         д) Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
//         e) Найти позицию подстроки “Java” в строке “I like Java!!!”.
//         ж) Заменить все символы “а” на “о”.
//         з) Преобразуйте строку к верхнему регистру.
//         и) Преобразуйте строку к нижнему регистру.
//         к) Вырезать строку Java c помощью метода String.substring().

import java.util.Locale;

public class HomeString {

    public static void main(String[] args) {

        String string = "I like Java!!!";

        printLastChar(string);

        System.out.println(string.endsWith("!!!"));
        System.out.println(string.startsWith("I like"));
        System.out.println(string.contains("Java"));
        System.out.println(string.indexOf("Java"));
        System.out.println(string.replace("a","o"));
        System.out.println(string.toUpperCase(Locale.ROOT));
        System.out.println(string.toLowerCase());

        delete(string, "Java");
    }

    public static void delete(String s, String del){
        int first = s.indexOf(del);
        int last = first + del.length();
        System.out.println(s.substring(0, first) + s.substring(last, s.length()));
    }

    public static void printLastChar(String s){
        System.out.print("1. last character: " + s.charAt(s.length() - 1));
        System.out.println();
        System.out.println("2. last character: " + s.substring(s.length() - 1));
    }

}
