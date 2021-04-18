package lesson2;

@SuppressWarnings({"RedundantIfStatement", "ConstantConditions", "SameParameterValue"})
public class HomeWork2 {

    public static void main(String[] args) {

        System.out.println(checkSum(6,12));
        checkNumber(-6);
        System.out.println(checkNumberBoolean(0));
        printString("строка длинная", 5);
        System.out.println(checkYear(2024));
    }

    private static boolean checkSum(int a, int b) {

        int sum = a + b;
        if (sum >= 10 && sum <= 20) return true;
        else return false;
    }

    private static void checkNumber(int a) {

        if (a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    private static boolean checkNumberBoolean(int a) {

        boolean result;
        result = a <= 0;
        return (result);
    }

    private static void printString(String a, int b) {

        for (int i = 0; i < b; i++){
        System.out.println(a);
        }
    }

    private static boolean checkYear(int a) {

        if((a %= 400) == 0){
           return true;
        } else if (((a %= 100) == 0 && (a %= 400) != 0) || (a %= 400) < 400 && (a %= 4) != 0){
            return false;
        } else if ((a %= 4) == 0) {
            return true;
        } else return false;

    }
}