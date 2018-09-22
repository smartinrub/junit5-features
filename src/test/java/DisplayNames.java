import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Display name test suite")
class DisplayNames {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayName.class);

    @Test
    @DisplayName("My Custom Test Name")
    void displayNameTest() {
        LOGGER.info("displays name");
    }

    @Test
    @DisplayName("\uD83D\uDE03")
    void displayEmojiTest() {
        LOGGER.info("displays happy emoji");
    }
}
