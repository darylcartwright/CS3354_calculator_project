package calculatordemo2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;


    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests the square function")
    @Test
    void testSquare() {
        double num = 5.0;
        assertEquals(num*num, classUnderTest.calcScience(Calculator.singleOperator.square, num));
    }

    @DisplayName("Tests the square root function")
    @Test
    void testSquareRoot() {
        double num = 9.0;
        assertEquals(Math.sqrt(num), classUnderTest.calcScience(Calculator.singleOperator.squareRoot, num));
    }

    @DisplayName("Tests the 1/x function")
    @Test
    void testOneDividedBy() {
        double num = 2.0;
        assertEquals(1/num, classUnderTest.calcScience(Calculator.singleOperator.oneDividedBy, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testCos() {
        double num = 45.0;
        assertEquals(Math.cos(num), classUnderTest.calcScience(Calculator.singleOperator.cos, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        assertEquals(Math.sin(num), classUnderTest.calcScience(Calculator.singleOperator.sin, num));
    }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        assertEquals(Math.tan(num), classUnderTest.calcScience(Calculator.singleOperator.tan, num));
    }

    @DisplayName("Tests the inverse sine function in degrees")
    @Test
    void testArcsin() {
        double num = 0.5;
        assertEquals(Math.asin(num), classUnderTest.calcScience(Calculator.singleOperator.arcsin, num));
    }

    @DisplayName("Tests the inverse cosine function in degrees")
    @Test
    void testArccos() {
        double num = 0.5;
        assertEquals(Math.acos(num), classUnderTest.calcScience(Calculator.singleOperator.arccos, num));
    }

    @DisplayName("Tests the inverse tangent function in degrees")
    @Test
    void testArctan() {
        double num = 0.5;
        assertEquals(Math.atan(num), classUnderTest.calcScience(Calculator.singleOperator.arctan, num));
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }

    //7 unit tests for twoOpOperations()

    @DisplayName("Tests twoOpOperations with addition")
    @Test
    void testTwoOpOperationsAddition() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 7.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 2.0);
        assertEquals(9.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with subtraction")
    @Test
    void testTwoOpOperationsSubtraction() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.subtract, 5.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.subtract, 3.0);
        assertEquals(2.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with multiplication")
    @Test
    void testTwoOpOperationsMultiplication() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 4.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 6.0);
        assertEquals(24.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with division")
    @Test
    void testTwoOpOperationsDivision() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.divide, 18.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.divide, 2.0);
        assertEquals(9.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with zero as the second operand")
    @Test
    void testTwoOpOperationsWithZeroSecondOperand() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 8.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 0.0);
        assertEquals(8.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with multiplication by zero")
    @Test
    void testTwoOpOperationsMultiplicationByZero() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 3.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 0.0);
        assertEquals(0.0, classUnderTest.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with division by zero")
    @Test
    void testTwoOpOperationsDivisionByZero() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.divide, 5.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.divide, 0.0);
     
        double result = classUnderTest.twoOpOperations();
        assertTrue(Double.isInfinite(result));
    }






    //2 unit tests for twoOpCaller()

    @DisplayName("Tests twoOpCaller with equals")
    @Test
    void testTwoOpCallerEquals() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 5.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 3.0);
        double result = classUnderTest.calculateEqual(0.0);
        assertEquals(8.0, result);
    }

    @DisplayName("Tests twoOpCaller with cancellation")
    @Test
    void testTwoOpCallerCancellation() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 5.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.add, 3.0);
        double result = classUnderTest.reset();
        assertEquals(Double.NaN, result);
    }

}
