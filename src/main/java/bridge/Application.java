package bridge;

import bridge.controller.Controller;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new BridgeGame(), new InputView(), new OutputView());
        controller.start();
    }
}
