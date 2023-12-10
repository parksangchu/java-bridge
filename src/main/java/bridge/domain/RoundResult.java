package bridge.domain;

public class RoundResult {
    private final String moving;
    private final boolean isRightWay;

    public RoundResult(String moving, boolean isRightWay) {
        this.moving = moving;
        this.isRightWay = isRightWay;
    }

    public String getMoving() {
        return moving;
    }

    public boolean isRightWay() {
        return isRightWay;
    }
}
