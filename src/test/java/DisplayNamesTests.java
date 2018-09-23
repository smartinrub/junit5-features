import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display name test suite")
class DisplayNamesTests {

    @Test
    @DisplayName("My Custom Test Name")
    void displayNameTest() {

    }

    @Test
    @DisplayName("\uD83D\uDE03") // Happy Emoji
    void displayEmojiTest() {

    }
}
