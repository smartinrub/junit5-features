import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // it needs to be added to make @BeforeAll and @AfterAll work
interface Interfaces {

    Logger LOGGER = LoggerFactory.getLogger(Interfaces.class);

    @BeforeAll
    default void initAll() {
        LOGGER.info("Runs before all tests");
    }

    @AfterAll
    default void tearDownAll() {
        LOGGER.info("Runs after all tests");
    }

    @BeforeEach
    default void init(TestInfo testInfo) {
        LOGGER.info("Starting test: {}", testInfo.getDisplayName());
    }

    @AfterEach
    default void tearDown(TestInfo testInfo) {
        LOGGER.info("Finishing test: {}", testInfo.getDisplayName());
    }

}

class ClassImplementingInterface implements Interfaces {

    @Test
    void myTest() {

    }
}

