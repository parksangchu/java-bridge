package bridge.domain;

public class BridgeLength {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final int number;

    public BridgeLength(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_LENGTH || number > MAX_LENGTH) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
