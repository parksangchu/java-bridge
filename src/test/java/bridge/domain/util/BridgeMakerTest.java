package bridge.domain.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @ParameterizedTest
    @DisplayName("다리 크기를 매개 변수로 받아 같은 크기의 다리를 제작한다.")
    @ValueSource(ints = {3, 4, 5, 20})
    void makeBridge(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(input);
        assertThat(bridge.size()).isEqualTo(input);
    }
}