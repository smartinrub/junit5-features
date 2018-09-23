import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicFeaturesTests {

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll runs once before all tests");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach runs before each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll runs once after all tests");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach runs after each test");
    }

    @Test
    void successfulTest() {
        assertTrue(2 < 5);
    }
}
