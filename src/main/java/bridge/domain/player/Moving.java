package bridge.domain.player;

import static bridge.domain.constants.Constants.DOWN_SIDE;
import static bridge.domain.constants.Constants.UPPER_SIDE;

public class Moving {
    private static final String DIRECTION_ERROR = "[ERROR] 올바른 방향이 아닙니다.";
    private final String direction;

    public Moving(String direction) {
        validate(direction);
        this.direction = direction;
    }

    private void validate(String direction) {
        if (!direction.equals(UPPER_SIDE.getDirection()) && !direction.equals(DOWN_SIDE.getDirection())) {
            throw new IllegalArgumentException(DIRECTION_ERROR);
        }
    }

    public boolean isUpperSide() {
        return direction.equals(UPPER_SIDE.getDirection());
    }

    public String getDirection() {
        return direction;
    }
}
