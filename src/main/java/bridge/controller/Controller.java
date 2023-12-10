package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.domain.Player;
import bridge.domain.Turn;
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
        Turn turn = new Turn();
        while (true) {
            Moving moving = createMoving();
            player.initMoving(moving);
            bridgeGame.move();
            List<List<String>> map = bridgeGame.getMap();
            outputView.printMap(map);
            if (bridgeGame.isFail()) {
                GameCommand gameCommand = createGameCommand();
                if (gameCommand.isQuit()) {
                    break;
                }
                bridgeGame.retry();
                turn.increaseTurn();
            }
            if (bridgeGame.isEnd()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getMap(), bridgeGame.isFail(), turn.getNumber());
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

    private Moving createMoving() {
        while (true) {
            try {
                return new Moving(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private GameCommand createGameCommand() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                return new GameCommand(command);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
