import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NestedTests {

    private List<String> strings;

    @Nested
    class listIsInstantiated {

        @BeforeEach
        void init() {
            strings = new ArrayList<>();
        }

        @Test
        void listIsEmpty() {
            assertTrue(strings.isEmpty());
        }

        @Nested
        class afterAddingString {

            @BeforeEach
            void init() {
                strings.add("hello");
            }

            @Test
            void listIsNotEmpty() {
                assertFalse(strings.isEmpty());
            }
        }
    }
}
