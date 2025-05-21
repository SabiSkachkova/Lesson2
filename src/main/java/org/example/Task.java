package org.example;

public class Task {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 19;
        int b = 8;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 19;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 19;
        int b = 8;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void checkSumInRange() {
        System.out.println(checkSumInRange(18, 1));
        System.out.println(checkSumInRange(1, 19));
        System.out.println(checkSumInRange(20, 1));
    }

    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumberSign() {
        printNumberSign(19);
        printNumberSign(0);
        printNumberSign(-8);
    }

    public static void printNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static void isNegative() {
        System.out.println(isNegative(1));
        System.out.println(isNegative(0));
        System.out.println(isNegative(-1));
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes() {
        printStringMultipleTimes("Солнце восходит на востоке", 3);
        printStringMultipleTimes("Лес растворился в темноте", 2);
    }

    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void isLeapYear()  {
        System.out.println(isLeapYear(2025));
        System.out.println(isLeapYear(1998));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1600));
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static void printArrayOne() {
        int[] arrayOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив:");
        printArrayOne(arrayOne);
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] == 0) {
                arrayOne[i] = 1;
            } else {
                arrayOne[i] = 0;
            }
        }
        System.out.println("Измененный массив:");
        printArrayOne(arrayOne);
    }

    public static void printArrayOne(int[] arrayOne) {
        for (int num : arrayOne) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayTwo()  {
        int[] arrayTwo = new int[100];
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = i + 1;
        }
        System.out.println("Заполненный массив:");
        printArrayTwo(arrayTwo);
    }

    public static void printArrayTwo(int[] arrayTwo) {
        for (int num : arrayTwo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayThree()  {
        int[] arrayThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayThree.length; i++) {
            if (arrayThree[i] < 6) {
                arrayThree[i] *= 2;
            }
        }
        System.out.println("Измененный массив:");
        printArrayThree(arrayThree);
    }

    public static void printArrayThree(int[] arrayThree) {
        for (int num : arrayThree) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayFour() {
        int size = 5;
        int[][] arrayFour = new int[size][size];
        for (int i = 0; i < size; i++) {
            arrayFour[i][i] = 1;
        }
        System.out.println("Квадратный двумерный массив с единицами на главной диагонали:");
        printArrayFour(arrayFour);
    }

    public static void printArrayFour(int[][] arrayFour) {
        for (int[] row : arrayFour) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void printArrayFive() {
        int len = 8;
        int initialValue = 19;
        int[] resultArray = createArray(len, initialValue);
        System.out.println("Созданный массив:");
        printArrayFive(resultArray);
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printArrayFive(int[] arrayFive) {
        for (int num : arrayFive) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
