package bridge.domain.system;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {
    @ParameterizedTest
    @DisplayName("Q 혹은 R을 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"A", "B", "C", "Z",})
    void create(String input) {
        assertThatThrownBy(() -> new GameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatCode(() -> new GameCommand("Q")).doesNotThrowAnyException();
        assertThatCode(() -> new GameCommand("R")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("R을 입력하면 게임을 재시도한다.")
    void isRetry() {
        assertThat(new GameCommand("R").isQuit())
                .isFalse();
    }
}