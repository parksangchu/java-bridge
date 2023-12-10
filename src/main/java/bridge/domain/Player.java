package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String RIGHT_WAY = "O";
    private static final String WRONG_WAY = "X";
    private static final String NONE = " ";
    private int position;
    private Moving moving;
    private List<List<String>> map;


    public void initMoving(Moving moving) {
        this.moving = moving;
        position = 0;
    }

    private void initMap() {
        List<String> upperSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>();
        map = new ArrayList<>();
        map.add(upperSide);
        map.add(downSide);
    }

    public void recordMap(boolean isRightWay) {
        String object = selectObject(isRightWay);
        if (moving.isUpperSide()) {
            map.get(0).add(object);
            map.get(1).add(NONE);
            return;
        }
        map.get(0).add(NONE);
        map.get(1).add(object);
    }

    private String selectObject(boolean isRightWay) {
        if (isRightWay) {
            return RIGHT_WAY;
        }
        return WRONG_WAY;
    }

    public void crossBridge() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getMoving() {
        return moving.getDirection();
    }
}
