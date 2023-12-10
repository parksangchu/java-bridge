package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> map;

    public Bridge(List<String> map) {
        this.map = map;
    }

    public boolean isWrongWay(Player player) {
        return !map.get(player.getPosition() - 1)
                .equals(player.getMoving());
    }
}
