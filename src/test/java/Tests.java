package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    @Test
    public void testFactorial() {
        assertEquals(40320, FactorialCalculator.factorial(8));
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }

    @Test
    public void testTriangleArea() {
        assertEquals(931.0, TriangleArea.area(19, 98));
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(-1, 19));
    }

    @Test
    public void testCalculator() {
        assertEquals(27, Calculator.add(19, 8));
        assertEquals(11, Calculator.subtract(19, 8));
        assertEquals(152, Calculator.multiply(19, 8));
        assertEquals(2.375, Calculator.divide(19, 8));
        assertThrows(ArithmeticException.class, () -> Calculator.divide(19, 0));
    }

    @Test
    public void testNumberComparer() {
        assertEquals("1 больше чем 0", NumberComparer.compare(1, 0));
        assertEquals("8 меньше чем 19", NumberComparer.compare(8, 19));
        assertEquals("27 равно 27", NumberComparer.compare(27, 27));
    }
}
