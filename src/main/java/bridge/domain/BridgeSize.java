package bridge.domain;

public class BridgeSize {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final int number;

    public BridgeSize(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_SIZE || number > MAX_SIZE) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }
}
