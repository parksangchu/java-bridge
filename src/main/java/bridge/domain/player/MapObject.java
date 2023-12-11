package bridge.domain.player;

public enum MapObject {
    UNSELECTED_WAY(" "),
    RIGHT_WAY("O"),
    WRONG_WAY("X");

    private final String symbol;

    MapObject(String symbol) {
        this.symbol = symbol;
    }

    public static MapObject of(boolean isSuccess) {
        if (isSuccess) {
            return RIGHT_WAY;
        }
        return WRONG_WAY;
    }

    public static MapObject of() {
        return UNSELECTED_WAY;
    }

    public String getSymbol() {
        return symbol;
    }
}
