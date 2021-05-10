package ru.geekbrains.java1.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static final char DOT_EMPTY = '-';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int CHECK_WIN = 4; // кол-во фишек на победу

    public static char[][] map = new char[0][0];
    public static int DIFF = 1; // сложность игры

    public static void main(String[] args) {
        
        initGame();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(isWin(DOT_X)){
                System.out.println("Человек победил! ");
                if(repeatGame()) continue;
                else break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
            computerTurn();
            printMap();
            if(isWin(DOT_O)){
                System.out.println("Копьютер победил! ");
                if(repeatGame()) continue;
                else break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
        }

    }

    private static void initGame() {

        do {
            System.out.println("Выберите сложность игры : \n 1 - случайные ходы компьютера, \n 2 - игровое поле 5х5 (победа в 4 хода) \n 3 - блокировка хода человека");
            Scanner sc = new Scanner(System.in);
            DIFF = readInt(sc);

            if(DIFF == 1){
                map = new char[3][3];
                break;
            } else if (DIFF == 2 || DIFF == 3) {
                map = new char[5][5];
                break;
            } else {
                 System.out.println("Неверно указана сложность!");
            }
        } while (true);

        for (char[] chars : map) {
            Arrays.fill(chars, DOT_EMPTY);
        }
    }

    private static void printMap() {

        for (int i = 0; i <= map.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < map.length; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j <map.length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    } // вывод игрового поля

    private static boolean isMapFull(){
        for (int i =0; i< map.length; i++){
            for (int j = 0; j < map.length; j++){
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    } // проверка заполнения игрового поля

    private static boolean isWin(char symbol){
        int lastIndex = map.length - 1;
        int countMainDiagonal = 0;
        int countSideDiagonal = 0;

        for (int i = 0; i < map.length; i++){
            int countH = 0;
            int countV = 0;
            for (int j = 0; j < map.length; j++){
                if (map[j][i] == symbol) {                    // проверка вертикалей и горизонталей
                    countV++;
                }
                if (map[i][j] == symbol) {
                    countH++;
                }
                if (countV == CHECK_WIN || countH == CHECK_WIN){
                    return true;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {      // проверка основных диагоналей
            int countDiagonal = 0;
            if (map[i][i] == symbol) {
                countMainDiagonal++;
            } else countMainDiagonal = 0;
            if (map[i][lastIndex - i] == symbol) {
                countSideDiagonal++;
            } else countSideDiagonal = 0;
            if (countMainDiagonal == map.length || countSideDiagonal == map.length){
                return true;
            }
        }
        if (DIFF > 1){
            return checkDiagonal(symbol);
        }
        return false;
    } // проверка на победу


    private static void computerTurn(){

        switch (DIFF){
            case 1:{
                compFirstLevel();
                break;
            }
            case 2:{
                compFirstLevel();
                //compSecondLevel();
                System.out.println(""); // чтобы switch на дубликат кейсов не ругался
                break;
            }
            case 3:{
                //compThirdLevel();
                break;
            }
            default: break;
        }
    }

    private static void compFirstLevel() {
        int x;
        int y;
        Random random = new Random();

        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map.length);
        } while (map[x][y] != DOT_EMPTY);
        map[x][y] = DOT_O;
    }

    private static void humanTurn(){
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите координаты : ");
            x = readInt(scanner) - 1;
            y = readInt(scanner) - 1;

            if (x < 0 || y < 0 || x >= map.length || y >= map.length){
                System.out.println("Максимальный размер : " + map.length);
                scanner.nextLine();
            }
            else if(map[x][y] != DOT_EMPTY){
                System.out.println("Клетка занята");
            }
            else {
                break;
            }
        } while (true);

        map[x][y] = DOT_X;
    }

    private static int readInt(Scanner scanner){
        return scanner.hasNextInt() ? scanner.nextInt() : -1;
    }

    private static boolean repeatGame(){
        System.out.println("Хотите повторить? 1 - да, 2 - нет");
        Scanner scanner = new Scanner(System.in);
        int answer = readInt(scanner);
        if(answer == 1) {
            initGame();
            printMap();
            return true;
        }
        return false;
    } // повтор игры

    private static boolean checkDiagonal(char symbol){
        int lastIndex = map.length - 1;
        int countD1 = 0; // диагональ выше главной
        int countD12 = 0; // диагональ ниже главной
        int countD2 = 0; // диагональ выше побочной
        int countD22 = 0; // диагональ ниже побочной

        for (int i = 0; i <= map.length - 2; i++) {      //

            if (map[i][i + 1] == symbol) {
                countD1++;
            } else {
                countD1 = 0;
            }
            if (map[i + 1][i] == symbol) {
                countD12++;
            } else {
                countD12 = 0;
            }

            if (map[i][lastIndex - i - 1] == symbol) {
                countD2++;
            } else {
                countD2 = 0;
            }
            if (map[i + 1][lastIndex - i] == symbol) {
                countD22++;
            } else {
                countD22 = 0;
            }
            if (countD1 == CHECK_WIN || countD12 == CHECK_WIN ||countD2 == CHECK_WIN || countD22 == CHECK_WIN){
                return true;
            }
        }
        return false;
    }
}

// для заданий с *** - не сраслось
//    private static int[] findDotEmpty(int x, int line){
//        int[] move = {-1, -1, -1};
//
//        for (int i = 1; i < map.length; i++){
//            if(map[x][i] == DOT_EMPTY){
//                move[0] = x;
//                move[1] = i;
//                return move;
//            }
//        }
//        return move;
//    } //поиск пустой ячейки для блокировки игрока
//
//    private static void compSecondLevel() {
//        int x = -1;
//        int y = -1;
//        int[] moveH = {-1, -1, 0};
//        int[] moveV = {-1, -1, 0};
//        int[] moveD;
//        int countH = 0;
//        int countV = 0;
//
//        for (int i = 0; i < map.length; i++){
//
//            for (int j = 0; j < map.length; j++){
//                if (map[j][i] == DOT_X) {                    // проверка вертикалей и горизонталей
//                    countV++;
//                }
//                if (map[i][j] == DOT_X) {
//                    countH++;
//                }
//            }
//            if (countV < (CHECK_WIN - 1)){                //проверка вероятной победы по верт., и поиск хода для ее блокировки
//                moveV = findDotEmpty(i, 1);
//                moveV[2] = CHECK_WIN - countV;
//            }
//            if (countH < (CHECK_WIN - 1)){                //проверка вероятной победы по горизон., и поиск хода для ее блокировки
//                moveH = findDotEmpty(i, 2);
//                moveH[2] = CHECK_WIN - countH;
//            }
//        }
//        if (moveH[2] > moveV[2]){
//            x = moveV[0];
//            y = moveV[1];
//
//        }else {
//            x = moveH[0];
//            y = moveH[1];
//        }
//        map[x][y] = DOT_O;
//    }