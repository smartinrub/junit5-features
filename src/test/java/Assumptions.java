import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class Assumptions {

    private static final Logger LOGGER = LoggerFactory.getLogger(Assumptions.class);

    @Test
    void trueAssumption() {
        assumeTrue(2 < 5);
        assertEquals(7, 3 + 4);
    }

    @Test
    void trueAssumptionTestIsSkippedAndExceptionIsThrown() {
        LOGGER.info("When assume fails test is skipped and TestAbortedException is thrown");
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
        LOGGER.info("When assume fails test is skipped and TestAbortedException is thrown");
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
        LOGGER.info("When assume fails test pass");
        String word = "word";
        assumingThat(
                "hello".equals(word),
                () -> assertEquals(3, 1 + 1)
        );
    }
}
