package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INT_REGEX = "^[0-9]+$";
    private static final String TYPE_ERROR = "[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    private void validateType(String input) {
        if (!input.matches(INT_REGEX)) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }
}
