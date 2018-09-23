import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

class ConditionalsTests {

    private static int counter = 0;

    @Test
    @Disabled("Disabled test (it used to be @Ignore in jUnit4)")
    void skippedTest() {
        // not executed
    }

    @Test
    @EnabledIf(value = "true", reason = "test runs because is true")
    void isExecuted() {
    }

    @DisabledIf("Math.random() < 0.5")
    @RepeatedTest(10)
    void sometimesIsExecuted() {
        System.out.println("Running " + counter++);
    }


}
