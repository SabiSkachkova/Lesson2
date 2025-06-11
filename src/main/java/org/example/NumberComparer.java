package org.example;

public class NumberComparer {
    public static String compare(int a, int b) {
        if (a > b) {
            return a + " больше чем " + b;
        } else if (a < b) {
            return a + " меньше чем " + b;
        } else {
            return a + " равно " + b;
        }
    }
}
