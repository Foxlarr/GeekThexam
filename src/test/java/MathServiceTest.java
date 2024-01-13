import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {

    @Test
    void testGetAnswerForNoRoots() {
        MathService mathService = new MathService();

        try {
            mathService.getAnswer(1, 1, 1);
            fail("Expected NotFoundAnswerException");
        } catch (NotFoundAnswerException e) {
            assertEquals("Корни не могут быть найдены", e.getMessage());
        }
    }

    @Test
    void testGetAnswerForOneRoot() {
        MathService mathService = new MathService();

        try {
            Pair result = mathService.getAnswer(1, -4, 4);
            assertEquals(2.0, result.first, 0.0001);
            assertEquals(2.0, result.second, 0.0001);
        } catch (NotFoundAnswerException e) {
            fail("Unexpected NotFoundAnswerException");
        }
    }

    @Test
    void testGetAnswerForTwoRoots() {
        MathService mathService = new MathService();

        try {
            Pair result = mathService.getAnswer(1, -3, -4);
            assertEquals(4.0, result.first, 0.0001);
            assertEquals(-1.0, result.second, 0.0001);
        } catch (NotFoundAnswerException e) {
            fail("Unexpected NotFoundAnswerException");
        }
    }

    @Test
    void testGetAnswerForComplexRoots() {
        MathService mathService = new MathService();

        try {
            Pair result = mathService.getAnswer(1, 1, 1);
            fail("Expected NotFoundAnswerException");
        } catch (NotFoundAnswerException e) {
            assertEquals("Корни не могут быть найдены", e.getMessage());
        }
    }

    @Test
    void testGetD() {
        MathService mathService = new MathService();

        int result = mathService.getD(1, -3, -4);

        assertEquals(25, result);
    }


    @DisplayName("Test getAnswer with coefficients: a={0}, b={1}, c={2}")
    @ParameterizedTest(name = "Expected roots: {3} and {4}")
    @CsvSource({
            "1, 1, 1, NotFoundAnswerException,",
            "1, -4, 4, 2.0, 2.0",
            "1, -3, -4, 4.0, -1.0",
            "1, 1, 1, NotFoundAnswerException,"
    })
    void testGetAnswer(int a, int b, int c, String expectedRoot1, String expectedRoot2) {
        MathService mathService = new MathService();

        try {
            Pair result = mathService.getAnswer(a, b, c);

            if (expectedRoot1.equals("NotFoundAnswerException")) {
                fail("Expected NotFoundAnswerException");
            } else {
                assertEquals(Double.parseDouble(expectedRoot1), result.first, 0.0001);
                assertEquals(Double.parseDouble(expectedRoot2), result.second, 0.0001);
            }
        } catch (NotFoundAnswerException e) {
            if (!expectedRoot1.equals("NotFoundAnswerException")) {
                fail("Unexpected NotFoundAnswerException");
            }
        }
    }
}