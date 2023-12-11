package bridge.domain;

public enum MapObject {
    UNSELECTED_WAY(" "),
    RIGHT_WAY("O"),
    WRONG_WAY("X");

    private final String symbol;

    MapObject(String symbol) {
        this.symbol = symbol;
    }

    public MapObject of(boolean isRightWay) {
        if (isRightWay) {
            return RIGHT_WAY;
        }
        return WRONG_WAY;
    }

    public String getSymbol() {
        return symbol;
    }
}
