import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

@Tag("assumptions")
class AssumptionsTests {


    @Test
    void trueAssumption() {
        assumeTrue(2 < 5);
        assertEquals(7, 3 + 4);
    }

    @Test
    void trueAssumptionTestIsSkippedAndExceptionIsThrown() {
        // When assume fails, test is skipped and TestAbortedException is thrown
        assumeTrue(2 < 1, () -> "Skipping test");
        assertEquals(7, 3 + 3);
    }

    @Test
    void falseAssumption() {
        assumeFalse(3 < 2);
        assertEquals(7, 4 + 3);
    }

    @Test
    void failFalseAssumptionTestIsSkippedAndExceptionIsThrown() {
        // When assume fails, test is skipped and TestAbortedException is thrown
        assumeFalse(1 < 2, "Skipping test");
        assertEquals(7, 2 + 3);
    }

    @Test
    void assumptionThat() {
        String word = "word";
        assumingThat(
                "word".equals(word),
                () -> assertEquals(3, 2 + 1)
        );
    }

    @Test
    void failAssumptionThatTestPass() {
        // When assume fails, test pass
        String word = "word";
        assumingThat(
                "hello".equals(word),
                () -> assertEquals(3, 1 + 1)
        );
    }
}
