package bridge.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingTest {
    @ParameterizedTest
    @DisplayName("U 혹은 D 이외의 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"u", "d", "a", "b", "1", "$"})
    void create(String input) {
        assertThatThrownBy(() -> new Moving(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatCode(() -> new Moving("U")).doesNotThrowAnyException();
        assertThatCode(() -> new Moving("D")).doesNotThrowAnyException();
    }
}