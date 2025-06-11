package org.example;

public class TriangleArea {
    public static double area(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Основание и высота не должны быть отрицательными.");
        }
        return 0.5 * base * height;
    }
}
