import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicFeaturesTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFeaturesTests.class);

    @BeforeAll
    static void initAll() {
        LOGGER.info("@BeforeAll runs once before all tests");
    }

    @BeforeEach
    void init() {
LOGGER.info("@BeforeEach runs before each test");
    }

    @AfterAll
    static void tearDownAll() {
        LOGGER.info("@AfterAll runs once after all tests");
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("@AfterEach runs after each test");
    }

    @Test
    @Disabled("Disabled test (it used to be @Ignore in jUnit4)")
    void skippedTest() {
        // not executed
    }

    @Test
    void successfulTest() {
        assertTrue(2 < 5);
    }
}
