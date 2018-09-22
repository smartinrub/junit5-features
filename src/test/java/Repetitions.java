import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Repetitions {

    private static int repetition = 1;

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("repetition")
    void repetitionTest(RepetitionInfo repetitionInfo) {
        assertEquals(repetition++, repetitionInfo.getCurrentRepetition());
        assertEquals(10, repetitionInfo.getTotalRepetitions());
    }
}
