package bridge.domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int position;
    private List<List<MapObject>> map;
    private Moving moving;

    public Player() {
        init();
    }

    public void init() {
        initPosition();
        initMap();
    }

    private void initPosition() {
        position = 0;
    }

    private void initMap() {
        List<MapObject> upperSide = new ArrayList<>();
        List<MapObject> downSide = new ArrayList<>();
        map = new ArrayList<>();
        map.add(upperSide);
        map.add(downSide);
    }

    public void initMoving(Moving moving) {
        this.moving = moving;
    }

    public void crossBridge() {
        position++;
    }

    public void recordMap(boolean isSuccess) {
        MapObject selectedWay = MapObject.of(isSuccess);
        MapObject unSelectedWay = MapObject.of();
        if (moving.isUpperSide()) {
            map.get(0).add(selectedWay);
            map.get(1).add(unSelectedWay);
            return;
        }
        map.get(0).add(unSelectedWay);
        map.get(1).add(selectedWay);
    }

    public int getPosition() {
        return position;
    }

    public String getMoving() {
        return moving.getDirection();
    }

    public List<List<MapObject>> getMap() {
        return Collections.unmodifiableList(map);
    }
}
