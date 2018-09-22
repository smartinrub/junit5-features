import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Dependency Injection Test Suite")
class DependencyInjection {

    private static final Logger LOGGER = LoggerFactory.getLogger(Conditionals.class);

    DependencyInjection(TestInfo testInfo) {
        assertEquals("Dependency Injection Test Suite", testInfo.getDisplayName());
    }

    @Nested
    class testInfoExamples {
        @BeforeEach
        void init(TestInfo testInfo) {
            String displayName = testInfo.getDisplayName();
            assertTrue(displayName.equals("Test Example") || displayName.equals("myTest()"));
        }

        @Test
        @DisplayName("Test Example")
        @Tag("my-tag")
        void test(TestInfo testInfo) {
            assertTrue(testInfo.getTags().contains("my-tag"));
        }

        @Test
        void myTest() {

        }
    }

    @Test
    void testReporterString(TestReporter testReporter) {
        LOGGER.info("Use test reporter to print information to stout or stderr");
        testReporter.publishEntry("my message");
    }

    @Test
    void testReporterKeyValue(TestReporter testReporter) {
        testReporter.publishEntry("myKey", "myValue");
    }

    @Test
    void testReporterMap(TestReporter testReporter) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("myKey", "myValue");
        testReporter.publishEntry(myMap);
    }


}
