import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Conditionals {

    private static final Logger LOGGER = LoggerFactory.getLogger(Conditionals.class);

    private static int counter = 0;

    @Test
    @EnabledIf("true")
    void isExecuted() {
        LOGGER.info("Running test...");
    }

    @DisabledIf("Math.random() < 0.5")
    @RepeatedTest(10)
    void sometimesIsExecuted() {
        LOGGER.info("Running {}", counter++);
    }


}
