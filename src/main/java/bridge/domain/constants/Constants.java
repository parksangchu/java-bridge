package bridge.domain.constants;

public enum Constants {
    UPPER_SIDE("U"),
    DOWN_SIDE("D");

    private final String direction;

    Constants(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
