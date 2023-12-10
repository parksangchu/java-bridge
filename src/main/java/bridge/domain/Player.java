package bridge.domain;

public class Player {
    private int position;
    private Moving moving;
    private boolean isFailed;


    public void initMoving(Moving moving) {
        this.moving = moving;
        position = 0;
        isFailed = false;
    }

    public void crossBridge() {
        position++;
    }

    public void fail() {
        isFailed = true;
    }

    public void retry() {
        isFailed = false;
    }

    public int getPosition() {
        return position;
    }

    public String getMoving() {
        return moving.getDirection();
    }
}
