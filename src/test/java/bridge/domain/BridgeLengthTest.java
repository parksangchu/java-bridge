package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeLengthTest {
    @ParameterizedTest
    @DisplayName("3-20 사이의 숫자가 아니면 예외를 발생시킨다.")
    @ValueSource(ints = {1, 2, 21})
    void create(int input) {
        assertThatThrownBy(() -> new BridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}