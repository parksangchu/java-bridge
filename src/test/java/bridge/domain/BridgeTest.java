package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void isRightWay() {
        List<String> structure = new ArrayList<>(List.of("U", "D", "U"));
        Bridge bridge = new Bridge(structure);
        Player player = new Player();
        Moving moving = new Moving("U");
        player.initMoving(moving);
        player.crossBridge();
        assertThat(bridge.isRightWay(player)).isTrue();
    }
}