import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterizedTests {

    enum MyEnum {RED, GREEN, BLACK}

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void integerParameters(int value) {
        assertEquals(0, value % 2);
    }


    @ParameterizedTest
    @EnumSource(value = MyEnum.class, names = {"RED", "GREEN"})
    void integerParameters(MyEnum myEnum) {
        assertTrue(EnumSet.of(MyEnum.RED, MyEnum.GREEN).contains(myEnum));
    }

    @ParameterizedTest
    @MethodSource("myStrings") // if method has same name as test, name parameter is not required
    void methodSourceProvider(String string) {
        assertTrue(Arrays.asList("hello", "world").contains(string));
    }

    static List<String> myStrings() {
        return Arrays.asList("hello", "world");
    }
}
