package lesson3;

import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] args) {

        int[] array1 = {1, 0, 1, 0};
        arrayInvert(array1);

        int[] array2 = new int[100];
        arrayEmpty(array2);

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrayDouble(array3);

        int[][] array4 = new int[5][5];
//        System.out.println(Arrays.toString(array4[0]));
        arrayDiagonal(array4);

        System.out.println(Arrays.toString(arrayCreate(5, 1)));

        int[] array5 = {1, 5, 3, 2, 11, 4, 5, 0, 4, 8, 9, 1};
        arrayMaxMin(array5);

        int[] array6 = {1, 5, 3, 2, 1, 4, 6, 0, 4, 8, 9, 5};
        arrayCheckBalance(array6);

        int[] array7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayShift(array7);
//        int[] array = new int[2];
//        int[] array = new int[] {1, 2, 3};
//
//        System.out.println(Arrays.toString(array));
//        System.out.println(array.length);
//        System.out.println(array.length-1);
//
//        int[] data = {1,2,3,4,5,6,7,12};
//        for(int i = 0; i < data.length; i++){

    }

    private static void arrayInvert(int[] array) {

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("______________________");
    }

    private static void arrayEmpty(int[] array) {

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("______________________");
    }

    private static void arrayDouble(int[] array) {

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("______________________");
    }

    private static void arrayDiagonal(int[][] array) {

        int d1 = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                    array[i][d1] = 1;
                    d1--;
                }
            }
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("5______________________");
    }

    private static int[] arrayCreate(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) array[i] = initialValue;
        return array;
    }

    private static void arrayMaxMin(int[] array) {
//            Math.min(array[i], min);  Math.min(array[i], min);

        System.out.println("6______________________");
        System.out.println(Arrays.toString(array));
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
            min = array[i] < min ? array[i] : min;
        }
        System.out.println("Минимальное значение в массиве: " + min);
        System.out.println("Максимальное значение в массиве: " + max);
    }

    private static void arrayCheckBalance(int[] array) {

        System.out.println("7______________________");
        System.out.println(Arrays.toString(array));

        int left = 0;

        for (int i = 0; i < array.length; i++) {
            left += array[i];
            int right = 0;
            for (int j = i + 1; j < array.length; j++) {
                right += array[j];
                if (left == right && j == (array.length - 1)) {
                    i++;
                    System.out.println("Баланс : " + left + " = " + right + " находиться после " + i + " элемента массива");
                    break;
                }

            }
        }
    }

    private static void arrayShift(int[] arr) {

        System.out.println("\n8______________________");
        System.out.println(Arrays.toString(arr));
        System.out.println("Задайте величину сдвига для массива (целое число): ");

        Scanner scanner = new Scanner(System.in);
        int shift = scanner.nextInt();

        if(shift < 0) {
            System.out.println("\nСдвиг влево на " + Math.abs(shift) + " значений");
            for (int i = 0; i < Math.abs(shift); i++) {
                int arrCellA = 0;
                int arrCellB = 0;
                for (int j = (arr.length - 1); j > 0; j--) {

                    if (j < arr.length - 1 && j > 1) {
                        arrCellA = arr[j - 1];
                        arr[j - 1] = arrCellB;
                        arrCellB = arr[j - 2];
                        arr[j - 2] = arrCellA;
                        j--;
                    } else if (j == arr.length - 1) {
                        arrCellA = arr[j];     //запоминаем 1 ячейку
                        arrCellB = arr[j - 1];
                        arr[arr.length - 2] = arr[j];
                        arr[arr.length - 1] = arr[0]; //
                        //j++;
                    } else {
                        arr[0] = arrCellB;
                    }
                }
            }
        }
        else {
            System.out.println("\nСдвиг вправо на " + Math.abs(shift) + " значения");
            for (int i = 0; i < shift; i++) {
                int arrCellA = 0;
                int arrCellB = 0;
                for (int j = 0; j < arr.length - 1; j++) {

                    if (j < arr.length - 2 && j > 0) {
                        arr[j + 1] = arrCellA;
                        arrCellA = arr[j + 2];
                        arr[j + 2] = arrCellB;
                        arrCellB = arr[j + 3];
                        j++;
                    } else if (j == 0) {
                        arrCellA = arr[j + 1];     //запоминаем 1 ячейку
                        arrCellB = arr[j + 2];
                        arr[1] = arr[j];       //перенос 0 ячейки в 1
                        arr[0] = arr[arr.length - 1]; // перенос крайнего значения в 0 ячейку
                        //j++;
                    } else {
                        arr[j + 1] = arrCellA;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}