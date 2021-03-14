package ru.geekbrains.jc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Задать целочисленный массив, состоящий из элементов 0 и 1.
        // С помощью цикла и условия заменить 0 на 1, 1 на 0.
        System.out.println("Задание 1");
        int[] arraysOne = new int[] {0,1,0,0,1};
        for (int i = 0; i < arraysOne.length; i++) {
            arraysOne[i] = arraysOne[i] == 1 ? 0 : 1;
        } System.out.println(Arrays.toString(arraysOne));

        // Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
        System.out.println("Задание 2");
        int[] arraysTwo = new int[8];
        for (int i = 0, j = 0; i < arraysTwo.length; i++, j += 3) {
            arraysTwo[i] = j;
        } System.out.println(Arrays.toString(arraysTwo));

        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2.
        System.out.println("Задание 3");
        int[] arraysThree = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i= 0; i < arraysThree.length; i++) {
            if (arraysThree[i] < 6) arraysThree[i] *= 2;
        } System.out.println(Arrays.toString(arraysThree));

        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
        System.out.println("Задание 4");
        int n = 8;
        int[][] arraysFour = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0, j2 = n; j < n; j++, j2=j-2) {
                if (i == j || i == j2) arraysFour[i][j] = 1;
                System.out.print(arraysFour[i][j] + "   ");
            } System.out.println();
        }

        // Задать одномерный массив и найти в нем минимальный и максимальный элементы
        System.out.println("Задание 5");
        int[] arraysFive = new int [] {23, 19, 59, 112, 5, 3, 21, 210};
        int min = 0;
        int max = 0;
        for (int j : arraysFive) {
            if (j > max) max = j;
            else min = j;
        } System.out.println("Минимальный элемент = " + min + "; Максимальный элемент = " + max);

        System.out.println("Задание 6");
        int[] arraysSix = new int[] {-2, 2, 1, 5, 8, -2};
        checkSum(arraysSix);
        System.out.println(Arrays.toString(arraysSix)); // Вывод массива в консоль.
        System.out.println(checkSum(arraysSix));        // Результат выполнения метода.

        System.out.println("Задание 7");
        int[] arraysSeven = new int[] {-2, 2, 1, 5, 8, -2};
        newPosition(arraysSeven);
        System.out.println(Arrays.toString(arraysSeven));
    }

        // Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean checkSum(int[] arraysSix){
        int sum = Arrays.stream(arraysSix).sum();
        for (int lSum = 0, i = 0; i < arraysSix.length; i++){
            lSum += arraysSix[i];
            int rSum = sum - lSum;
            if (lSum == rSum) return true;}
        return false;
    }

        // Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        // при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    public static void newPosition(int[] arraysSeven){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n: ");
        int number = scanner.nextInt();
        int size = arraysSeven.length;
        if (number > 0)
            for (int j = 0; j < number; j++){
                int temp = arraysSeven[0];
                System.arraycopy(arraysSeven, 1, arraysSeven, 0, size - 1);
                arraysSeven[arraysSeven.length-1] = temp;}
        else
            for (int j = 0; j > number; j--){
                int temp = arraysSeven[arraysSeven.length-1];
                System.arraycopy(arraysSeven, 0, arraysSeven, 1, size - 1);
                arraysSeven[0] = temp;}
    }
}