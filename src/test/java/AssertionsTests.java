import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

@Tag("assertions")
class AssertionsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssertionsTests.class);

    @Test
    void lambdaAssertionWithMessage() {
        assertEquals(Stream.of(1, 4, 5).mapToInt(Integer::intValue).sum(), 10, "Sum should be 10");
    }

    @Test
    void groupAssertion() {
        List<String> names = Arrays.asList("Sergio", "Juan", "Adolfo");
        assertAll("names",
                () -> assertEquals("Sergio", names.get(0)),
                () -> assertEquals("Juan", names.get(1)),
                () -> assertEquals("Adolfo", names.get(2)));
    }

    @Test
    void multipleDependentAssertions() {
        String name = "Sergio";
        String surname = "Martin";

        // You can add as many lambda expressions as you want
        // if one of them fails the next assertions will be skipped
        assertAll("check name", () -> {
                    assertNotNull(name);

                    // Executed if previous assertion is successful
                    assertAll("check name first and last letter", () -> {
                        assertEquals('S', name.charAt(0));
                        assertEquals('o', name.charAt(name.length() - 1));
                    });
                },
                () -> {
                    assertNotNull(surname);

                    assertAll("check name first and last letter", () -> {
                        assertEquals('M', surname.charAt(0));
                        assertEquals('n', surname.charAt(surname.length() - 1));
                    });
                });
    }

    @Test
    void shouldThrowException() {
        Throwable runtimeException = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("exception");
        });


        assertEquals("exception", runtimeException.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(2), () -> System.out.println("Hello"));
    }

    @Test
    void timeoutNotExceededWithResult() {
        String result  = assertTimeout(Duration.ofMinutes(2), () -> "hello");

        assertEquals("hello", result);
    }

    @Test
    @Disabled
    void timeoutExceeded() {
        LOGGER.info("Assertion fails with exceeded timeout of 2ms by 8ms");
        assertTimeout(Duration.ofMillis(2), () -> {
            sleep(10);
        });
    }
}
