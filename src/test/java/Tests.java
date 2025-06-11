package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {


    @Test
    public void testFactorial() {
        Assert.assertEquals(FactorialCalculator.factorial(6), 720, "Факториал 6 должен быть 720");
        Assert.assertEquals(FactorialCalculator.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число не должно быть отрицательным.")
    public void testFactorialNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }


    @Test
    public void testTriangleArea() {
        Assert.assertEquals(TriangleArea.area(8, 2), 8.0, "Площадь должна быть 8.0");
        Assert.assertEquals(TriangleArea.area(0, 5), 0.0, "Площадь должна быть 0.0 для основания 0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Основание и высота не должны быть отрицательными.")
    public void testTriangleAreaNegativeValue() {
        TriangleArea.area(-1, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Основание и высота не должны быть отрицательными.")
    public void testTriangleAreaNegativeHeight() {
        TriangleArea.area(4, -1);
    }


    @Test
    public void testArithmeticOperations() {
        Assert.assertEquals(Calculator.add(2, 3), 5, "2 + 3 должно быть 5");
        Assert.assertEquals(Calculator.subtract(3, 2), 1, "3 - 2 должно быть 1");
        Assert.assertEquals(Calculator.multiply(2, 3), 6, "2 * 3 должно быть 6");
        Assert.assertEquals(Calculator.divide(6, 3), 2.0, "6 / 3 должно быть 2.0");
    }

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "Деление на ноль.")
    public void testArithmeticDivisionByZero() {
        Calculator.divide(1, 0);
    }


    @Test
    public void testNumberComparer() {
        Assert.assertEquals(NumberComparer.compare(19, 8), "19 больше чем 8", "19 должно быть больше чем 8");
        Assert.assertEquals(NumberComparer.compare(8, 19), "8 меньше чем 19", "8 должно быть меньше чем 19");
        Assert.assertEquals(NumberComparer.compare(5, 5), "27 равно 27", "27 должно быть равно 27");
    }
}
