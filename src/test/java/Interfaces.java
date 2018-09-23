import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // it needs to be added to make @BeforeAll and @AfterAll work
interface Interfaces {

    @BeforeAll
    default void initAll() {
        System.out.println("@BeforeAll runs once before all tests");
    }

    @BeforeEach
    default void init() {
        System.out.println("@BeforeEach runs before each test");
    }

    @AfterAll
    default void tearDownAll() {
        System.out.println("@AfterAll runs once after all tests");
    }

    @AfterEach
    default void tearDown() {
        System.out.println("@AfterEach runs after each test");
    }
}

class ClassImplementingInterfaceTests implements Interfaces {

    @Test
    void myTest() {

    }
}

