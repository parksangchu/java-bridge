package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.Moving;
import bridge.domain.Player;
import bridge.domain.util.BridgeMaker;
import bridge.domain.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartNotice();
        Player player = new Player();
        Bridge bridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(player, bridge);
        Moving moving = new Moving(inputView.readMoving());
        player.initMoving(moving);
    }

    private Bridge makeBridge() {
        BridgeSize bridgeSize = createBridgeSize();
        BridgeMaker bridgeMaker = createBridgeMaker();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getNumber());
        return new Bridge(bridge);
    }

    private BridgeSize createBridgeSize() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                return new BridgeSize(bridgeSize);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private BridgeMaker createBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
