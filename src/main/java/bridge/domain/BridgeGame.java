package bridge.domain;

import bridge.domain.bridge.Bridge;
import bridge.domain.player.MapObject;
import bridge.domain.player.Moving;
import bridge.domain.player.Player;
import bridge.domain.system.Turn;
import java.util.List;

public class BridgeGame {
    private final Player player;
    private final Bridge bridge;
    private final Turn turn;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
        turn = new Turn();
    }

    public void initMoving(Moving moving) {
        player.initMoving(moving);
    }

    public void move() {
        player.crossBridge();
        recordMap(isSuccess());
    }

    private void recordMap(boolean isRightWay) {
        player.recordMap(isRightWay);
    }

    public void retry() {
        player.retry();
        turn.increaseTurn();
    }

    public boolean isSuccess() {
        return bridge.isRightWay(player.getPosition(), player.getMoving());
    }

    public boolean isEnd() {
        return bridge.isFinal(player.getPosition());
    }

    public int getTurn() {
        return turn.getNumber();
    }

    public List<List<MapObject>> getMap() {
        return player.getMap();
    }
}
