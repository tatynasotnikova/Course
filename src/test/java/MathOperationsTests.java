import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathOperationsTests {
    @Test
    @DisplayName("Тестирование вычисления факториала")
    void factorialTest() {
        assertEquals(1,MathOperations.factorial(1));
        assertEquals(6,MathOperations.factorial(3));
        assertNotEquals(721, MathOperations.factorial(6));
        IllegalArgumentException positiveNumbersException = assertThrows(IllegalArgumentException.class, () -> {
            MathOperations.factorial(-6);
        });
        assertEquals("Факториал определен только для неотрицательных чисел", positiveNumbersException.getMessage());
    }

    @Test
    @DisplayName("Тестирование вычисления площади треугольника")
    void triangleAreaTest() {
        assertEquals(6, MathOperations.triangleArea(3, 4, 5));
        assertNotEquals(56, MathOperations.triangleArea(3, 4, 5));
        IllegalArgumentException positiveNumbersException = assertThrows(IllegalArgumentException.class, () -> { MathOperations.triangleArea(6, 0, 0); });
        assertEquals("Стороны треугольника должны быть положительными числами", positiveNumbersException.getMessage());
        IllegalArgumentException notTriangleException = assertThrows(IllegalArgumentException.class, () -> {
            MathOperations.triangleArea(10, 2, 2);
        });
        assertEquals("Стороны не образуют треугольник", notTriangleException.getMessage());
    }

    @Test
    @DisplayName("Тестирование сложения")
    void addTest() {
        assertEquals(4, MathOperations.add(2,2));
        assertNotEquals(25, MathOperations.add(6, 8));
    }
    @Test
    @DisplayName("Тестирование вычитания")
    void subtractTest() {
        assertEquals(10, MathOperations.subtract(15, 5));
        assertNotEquals(5, MathOperations.subtract(10, 8));
    }

    @Test
    @DisplayName("Тестирование умножения")
    void multiplyTest() {
        assertEquals(18, MathOperations.multiply(2, 9));
        assertNotEquals(28, MathOperations.multiply(6, 4));
    }

    @Test
    @DisplayName("Тестирование деления")
    void divideTest() {
        assertEquals(2, MathOperations.divide(4, 2));
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> { MathOperations.divide(6, 0); });
        assertEquals("Деление на ноль невозможно", thrown.getMessage());
    }

    @Test
    @DisplayName("Тестирование сравнения")
    void compareWithDescriptionTest() {
        assertEquals("1 меньше 5", MathOperations.compareWithDescription(1, 5));
        assertEquals("6 равно 6", MathOperations.compareWithDescription(6, 6));
        assertEquals("8 больше 4", MathOperations.compareWithDescription(8, 4));
        assertNotEquals("17 меньше 7", MathOperations.compareWithDescription(17, 7));
        assertNotEquals("8 не равно 8", MathOperations.compareWithDescription(8, 8));
        assertNotEquals("2 больше 12", MathOperations.compareWithDescription(2, 12));
    }
}
