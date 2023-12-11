package bridge.domain;

import bridge.domain.bridge.Bridge;
import bridge.domain.player.MapObject;
import bridge.domain.player.Moving;
import bridge.domain.player.Player;
import java.util.List;

public class BridgeGame {
    private final Player player;
    private final Bridge bridge;
    private boolean isFail;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
        isFail = false;
    }

    public void initMoving(Moving moving) {
        player.initMoving(moving);
    }

    public void move() {
        player.crossBridge();
        boolean isRightWay = bridge.isRightWay(player);
        recordMap(isRightWay);
        checkMap(isRightWay);
    }

    private void recordMap(boolean isRightWay) {
        player.recordMap(isRightWay);
    }

    private void checkMap(boolean isRightWay) {
        if (!isRightWay) {
            isFail = true;
        }
    }

    public List<List<MapObject>> getMap() {
        return player.getMap();
    }

    public void retry() {
        player.retry();
        isFail = false;
    }

    public boolean isFail() {
        return isFail;
    }

    public boolean isEnd() {
        return bridge.isFinal(player);
    }
}
