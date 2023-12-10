package bridge.domain;

public class Moving {
    private static final String UPPER_SIDE = "U";
    private static final String DOWN_SIDE = "D";
    private final String direction;

    public Moving(String direction) {
        validate(direction);
        this.direction = direction;
    }

    private void validate(String direction) {
        if (direction.equals(UPPER_SIDE) && direction.equals(DOWN_SIDE)) {
            throw new IllegalArgumentException("[ERROR] 올바른 방향이 아닙니다.");
        }
    }

    public String getDirection() {
        return direction;
    }
}
