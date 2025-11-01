import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class MathOperationsTests {
    @Test
    void factorialTest() {
        assertEquals(1,MathOperations.factorial(1));
        assertEquals(6,MathOperations.factorial(3));
        assertNotEquals(MathOperations.factorial(6), 721);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidInputFactorial() {
        MathOperations.factorial(-9);
    }

    @Test
    void triangleAreaTest() {
        assertEquals(6.0, MathOperations.triangleArea(3, 4, 5));
        assertNotEquals(MathOperations.triangleArea(3, 4, 5), 56);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidInputTriangleArea() {
        MathOperations.triangleArea(6, 0, 0);
        MathOperations.triangleArea(10, 2, 2);
    }

    @Test
    void addTest() {
        assertEquals(4, MathOperations.add(2,2));
        assertNotEquals(MathOperations.add(6, 8), 25);
    }
    @Test
    void subtractTest() {
        assertEquals(10, MathOperations.subtract(15, 5));
        assertNotEquals(MathOperations.subtract(10, 8), 5);
    }

    @Test
    void multiplyTest() {
        assertEquals(18, MathOperations.multiply(2, 9));
        assertNotEquals(MathOperations.multiply(6, 4), 28);
    }

    @Test
    void divideTest() {
        assertEquals(2.0, MathOperations.divide(4, 2));
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void invalidInputDivide() {
        MathOperations.divide(6, 0);
    }

    @Test
    void compareWithDescriptionTest() {
        assertEquals("1 меньше 5", MathOperations.compareWithDescription(1, 5));
        assertEquals("6 равно 6", MathOperations.compareWithDescription(6, 6));
        assertEquals("8 больше 4", MathOperations.compareWithDescription(8, 4));
        assertNotEquals(MathOperations.compareWithDescription(17, 7), "17 меньше 7");
        assertNotEquals(MathOperations.compareWithDescription(8, 8), "8 не равно 8");
        assertNotEquals(MathOperations.compareWithDescription(2, 12), "2 больше 12");
    }
}
