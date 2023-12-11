package bridge.domain.bridge;

import java.util.List;

public class Bridge {
    private final List<String> structure;

    public Bridge(List<String> structure) {
        this.structure = structure;
    }

    public boolean isRightWay(int position, String direction) {
        return structure.get(position - 1)
                .equals(direction);
    }

    public boolean isFinal(int position) {
        return position == structure.size();
    }
}
