package put.io.testing.junit;

import com.sun.net.httpserver.Authenticator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUpCalc() {
        calc = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(2, calc.add(1,1));
        assertEquals(4, calc.add(2,2));
    }

    @Test
    void testMultiply() {
        assertEquals(4, calc.multiply(2,2));
        assertEquals(9, calc.multiply(3,3));
    }

    @Test
    void testAddPositiveNumbers() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                calc.addPositiveNumbers(-1, -3);
                });
    }
}

class FailureOrErrrorTest {
    private Calculator calc;
    @BeforeEach
    void setUpCalc() {
        calc = new Calculator();
    }

    @Test
    void test1() {
        assertEquals(2, calc.multiply(5,5));
    }

    @Test
    void test2() {
        assertEquals(-4, calc.addPositiveNumbers(-1, -3));
    }

    @Test
    void test3() {
        try {
            assertEquals(2, calc.multiply(20,20));
        }
        catch (Exception ex){ ex.printStackTrace();};
    }
}

