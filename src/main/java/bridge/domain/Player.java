package bridge.domain;

public class Player {
    private int position = 0;
ㄹ    private Moving moving;

    public void initMoving(Moving moving) {
        this.moving = moving;
    }

    public void crossBridge() {
        position++;
    }
}
