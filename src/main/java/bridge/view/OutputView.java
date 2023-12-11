package bridge.view;

import bridge.domain.player.MapObject;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String DELIMITER = " | ";
    private static final String MAP_FORMAT = "[ %s ]\n";
    private static final String RESULT_NOTICE = "\n최종 게임 결과";
    private static final String RESULT_FORMAT = "\n게임 성공 여부: %s\n총 시도한 횟수: %d\n";
    private static final String FAIL = "실패";
    private static final String SUCCESS = "성공";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public void printMap(List<List<MapObject>> map) {
        List<List<String>> symbols = map.stream()
                .map(mapObjects -> mapObjects.stream()
                        .map(MapObject::getSymbol).collect(Collectors.toList()))
                .collect(Collectors.toList());
        symbols.forEach(line -> System.out.printf(MAP_FORMAT, convertToString(line)));
    }

    public void printResult(List<List<MapObject>> map, boolean isFail, int number) {
        System.out.println(RESULT_NOTICE);
        printMap(map);
        System.out.printf(RESULT_FORMAT, convertToString(isFail), number);
    }

    private String convertToString(List<String> line) {
        return String.join(DELIMITER, line);
    }

    private String convertToString(boolean isFail) {
        if (isFail) {
            return FAIL;
        }
        return SUCCESS;
    }
}
