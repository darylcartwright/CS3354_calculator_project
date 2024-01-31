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
        double expectedResult = Math.cos(Math.toRadians(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.cos, num);
    
        assertEquals(expectedResult, actualResult, 1e-10, "Cosine result in degrees matches the expected value with tolerance");
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        double expectedResult = Math.sin(Math.toRadians(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.sin, num);

        assertEquals(expectedResult, actualResult, 1e-10, "Sine result in degrees matches the expected value with tolerance");
        }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        double expectedResult = Math.tan(Math.toRadians(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.tan, num);
        
        assertEquals(expectedResult, actualResult, 1e-10, "Tangent result in degrees matches the expected value with tolerance");
    }

    @DisplayName("Tests the inverse sine function in degrees")
    @Test
    void testArcsin() {
        double num = 0.5;
        double expectedResult = Math.toDegrees(Math.asin(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.arcsin, num);
    
        assertEquals(expectedResult, actualResult, 1e-10, "Inverse sine result in degrees matches the expected value with tolerance");
    }

    @DisplayName("Tests the inverse cosine function in degrees")
    @Test
    void testArccos() {
        double num = 0.5;
        double expectedResult = Math.toDegrees(Math.acos(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.arccos, num);
    
        assertEquals(expectedResult, actualResult, 1e-10, "Inverse cosine result in degrees matches the expected value with tolerance");
    }

    @DisplayName("Tests the inverse tangent function in degrees")
    @Test
    void testArctan() {
        double num = 0.5;
        double expectedResult = Math.toDegrees(Math.atan(num));
        double actualResult = classUnderTest.calcScience(Calculator.singleOperator.arctan, num);
    
        assertEquals(expectedResult, actualResult, 1e-10, "Inverse tangent result in degrees matches the expected value with tolerance");
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }

    //7 unit tests for twoOpOperations()

    @DisplayName("Test twoOpOperations with addition NEW")
    @Test
    void testTwoOpOperationsAddition() {
        Calculator calculator = new Calculator();
        calculator.num1 = 5.0;
        calculator.num2 = 3.0;
        calculator.mode = Calculator.twoOperator.add;
        assertEquals(8.0, calculator.twoOpOperations());
    }


    @DisplayName("Test twoOpOperations with subtraction NEW")
    @Test
    void testTwoOpOperationsSubtraction() {
        Calculator calculator = new Calculator();
        calculator.num1 = 8.0;
        calculator.num2 = 3.0;
        calculator.mode = Calculator.twoOperator.subtract;
        assertEquals(5.0, calculator.twoOpOperations());
    }


    @DisplayName("Test twoOpOperations with division NEW")
    @Test
    void testTwoOpOperationsDivision() {
        Calculator calculator = new Calculator();
        calculator.num1 = 9.0;
        calculator.num2 = 3.0;
        calculator.mode = Calculator.twoOperator.divide;
        assertEquals(3.0, calculator.twoOpOperations());
    }


    @DisplayName("Test twoOpOperations with multiplication NEW")
    @Test
    void testTwoOpOperationsMultiplication() {
        Calculator calculator = new Calculator();
        calculator.num1 = 4.0;
        calculator.num2 = 2.5;
        calculator.mode = Calculator.twoOperator.multiply;
        assertEquals(10.0, calculator.twoOpOperations());
    }

    @DisplayName("Tests twoOpOperations with multiplication by zero")
    @Test
    void testTwoOpOperationsMultiplicationByZero() {
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 3.0);
        classUnderTest.twoOpCaller(Calculator.twoOperator.multiply, 0.0);
        assertEquals(0.0, classUnderTest.twoOpOperations());
    }


    @DisplayName("Test twoOpOperations with normal mode")
    @Test
    void testTwoOpOperationsNormalMode() {
        Calculator calculator = new Calculator();
        calculator.num1 = 7.0;
        calculator.num2 = 2.0;
        calculator.mode = Calculator.twoOperator.normal;
        assertEquals(2.0, calculator.twoOpOperations());
    }

    @DisplayName("Test twoOpOperations with uninitialized mode")
    @Test
    void testTwoOpOperationsUninitializedMode() {
        Calculator calculator = new Calculator();
        calculator.num1 = 5.0;
        calculator.num2 = 3.0;
        calculator.mode = null;
        assertThrows(Error.class, calculator::twoOpOperations);
    }

 //2 unit tests for twoOpCaller()

 @DisplayName("Test twoOpCaller with addition")
 @Test
 void testTwoOpCallerAddition() {
     Calculator calculator = new Calculator();
     double result = calculator.twoOpCaller(Calculator.twoOperator.add, 5.0);
     assertEquals(Double.NaN, result);
     assertEquals(5.0, calculator.num1);
     assertEquals(Calculator.twoOperator.add, calculator.mode);
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
