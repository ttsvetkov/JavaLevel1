package lesson5;


public class HomeWork5 {

protected static final int PERS = 5;

    public static void main(String[] args) {

        Worker[] persArray = new Worker[PERS];

        for (int i = 0; i <= PERS-1; i++){
            persArray[i] = new Worker();
            System.out.println(persArray[i]);
        }

        System.out.println("\n ----------------Сотрудники страше сорока------------");

        for (int i = 0; i <= PERS-1; i++){
            if (persArray[i].getAge() > Worker.AGE_LIMIT){
                persArray[i].info();
            }
        }
    }


}
