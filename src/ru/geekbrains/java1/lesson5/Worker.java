package ru.geekbrains.java1.lesson5;

import java.util.Random;

public class Worker {
    public static int COUNT_PERS = 0;
    public static final int AGE_LIMIT = 40;
    private static final int AGE_THR = 20;
    private static final String mail = "@kontora.com";

    private String name;
    private int    age;
    private String post;
    private String email;
    private String phoneNumber;
    private int    pay;

    public Worker() {
        COUNT_PERS++;
        this.setName(nameGenerator());
        this.setAge(ageGenerator());
        this.setPost("должность № ");
        this.setEmail(mail, this.name, this.age );
        this.setPhoneNumber(phoneGenerator());
        this.setPay(COUNT_PERS);

    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Worker{" +
                " ФИО: " +'\"' + getName() + '\"' +
                " Возвраст: " + getAge() +
                " Должность: '" + getPost() + '\'' +
                " e-mail: '" + getEmail() + '\'' +
                " Телефон: " + getPhoneNumber() +
                " Зарплата: " + getPay() +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
    private static int ageGenerator(){
        Random random = new Random();
        return random.nextInt(AGE_LIMIT + 1) + AGE_THR;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static String nameGenerator(){
        Random random = new Random();
        int i = random.nextInt(COUNT_PERS);
        String[] name = { "Вася", "Петя", "Игорь", "Света", "Саша"};
        return name[i];
    }

    public void setEmail(String mail, String name, int age ) {
        this.email = name + "_" +age + mail;
    }

    public void setPay(int count) {
        this.pay = 100000 * count;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private static String phoneGenerator(){
        Random random = new Random();
        StringBuilder phone = new StringBuilder("+7-");

        for (int i = 0; i <= 9; i++){
            int number = random.nextInt(9) + 1;
            phone.append(number);
            if(i == 2 || i == 5 || i == 7){
                phone.append("-");
            }
        }
        return phone.toString();
    }

    public void setPost(String pos) {
        this.post = pos + COUNT_PERS;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPay() {
        return pay;
    }

    public String getEmail() {
        return email;
    }

    public String getPost() {
        return post;
    }
}
