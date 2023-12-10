package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> structure;

    public Bridge(List<String> structure) {
        this.structure = structure;
    }

    public boolean isRightWay(Player player) {
        return structure.get(player.getPosition() - 1)
                .equals(player.getMoving());
    }

    public boolean isFinal(Player player) {
        return player.getPosition() == structure.size();
    }
}
