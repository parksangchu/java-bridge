package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Player player;
    private final Bridge bridge;
    private boolean isFail;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
        isFail = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        player.crossBridge();
        boolean isRightWay = bridge.isRightWay(player);
        recordMap(isRightWay);
        notifyMap(isRightWay);
    }

    private void recordMap(boolean isRightWay) {
        player.recordMap(isRightWay);
    }

    private void notifyMap(boolean isRightWay) {
        if (!isRightWay) {
            isFail = true;
        }
    }

    public List<List<String>> getMap() {
        return player.getMap();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.retry();
        isFail = false;
    }

    public boolean isFail() {
        return isFail;
    }
}
