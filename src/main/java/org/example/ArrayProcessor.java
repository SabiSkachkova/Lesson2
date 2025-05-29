package org.example;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayProcessor {
    public static void arrayProcessor() {
        String[][] correctArray = {
                {"7676", "570", "9476", "46"},
                {"57", "98", "125", "48"},
                {"6", "18", "148", "1257"},
                {"5728", "1705", "1748874", "0"}
        };

        String[][] incorrectArraySize = {
                {"57", "5875"},
                {"349827", "5705"},
                {"4987", "10"}
        };

        String[][] incorrectArrayData = {
                {"7", "9", "87", "57"},
                {"98", "876", "№поtyut", "462"},
                {"765", "1000", "74", "74"},
                {"0", "1", "7905", "1980"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processArray(incorrectArraySize);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка с неправильным размером массива: " + e.getMessage());
        }

        try {
            processArray(incorrectArrayData);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка с неправильными данными в массиве: " + e.getMessage());
        }

        try {
            int[] arr = new int[5];
            System.out.println(arr[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}
