package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String DELIMITER = " | ";
    private static final String MAP_FORMAT = "[ %s ]\n";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        map.forEach(line -> System.out.printf(MAP_FORMAT, convertToString(line)));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private String convertToString(List<String> line) {
        return String.join(DELIMITER, line);
    }
}
