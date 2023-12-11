package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.player.Moving;
import bridge.domain.player.Player;
import bridge.domain.system.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private boolean run;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.run = true;
    }

    public void start() {
        outputView.printStartNotice();
        BridgeGame bridgeGame = readyGame();
        playGame(bridgeGame);
        outputView.printResult(bridgeGame.getMap(), bridgeGame.isSuccess(), bridgeGame.getTurn());
    }

    private BridgeGame readyGame() {
        Player player = new Player();
        Bridge bridge = createBridge();
        return new BridgeGame(player, bridge);
    }

    private Bridge createBridge() {
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

    private void playGame(BridgeGame bridgeGame) {
        while (run) {
            bridgeGame.initMoving(createMoving());
            bridgeGame.move();
            outputView.printMap(bridgeGame.getMap());
            checkRound(bridgeGame);
        }
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

    private void checkRound(BridgeGame bridgeGame) {
        if (!bridgeGame.isSuccess()) {
            checkCommand(bridgeGame);
        }
        if (bridgeGame.isEnd()) {
            run = false;
        }
    }

    private void checkCommand(BridgeGame bridgeGame) {
        GameCommand gameCommand = createGameCommand();
        if (gameCommand.isQuit()) {
            run = false;
            return;
        }
        bridgeGame.retry();
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
