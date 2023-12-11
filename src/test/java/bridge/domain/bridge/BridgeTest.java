package bridge.domain.bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.player.Moving;
import bridge.domain.player.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    Bridge bridge;
    Player player;

    @BeforeEach
    void setUp() {
        List<String> structure = new ArrayList<>(List.of("U", "D", "U"));
        bridge = new Bridge(structure);
        player = new Player();
    }

    @Test
    @DisplayName("플레이어가 올바른 칸으로 움직였는지 확인한다.")
    void isRightWay() {
        Moving moving = new Moving("U");
        player.initMoving(moving);
        player.crossBridge();
        assertThat(bridge.isRightWay(player)).isTrue();
    }

    @Test
    @DisplayName("플레이어가 다리의 종착지에 도착했는지 확인한다.")
    void isFinal() {
        for (int i = 0; i < 3; i++) {
            player.crossBridge();
        }
        assertThat(bridge.isFinal(player)).isTrue();
    }
}