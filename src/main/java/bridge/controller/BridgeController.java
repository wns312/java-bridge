package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.MoveDirection;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStartMessage();
        Bridge bridge = getBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (!bridgeGame.isSuccess()) {
            int position = crossBridge(bridgeGame);
            if (position == -1) {
                String command = getCommand();
                if (command.equals("Q")) {
                    outputView.printResult(bridgeGame.getMovingRoute(), bridgeGame.getTryCount(), bridgeGame.isSuccess());
                    return;
                }
                bridgeGame.retry();
                continue;
            }
            if (bridgeGame.isSuccess()) {
                outputView.printResult(bridgeGame.getMovingRoute(), bridgeGame.getTryCount(), bridgeGame.isSuccess());
                break;
            }
            outputView.printMap(bridgeGame.getMovingRoute());
        }
    }

    private String getCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int crossBridge(BridgeGame bridgeGame) {
        while (true) {
            try {
                String movingRoute = inputView.readMoving();
                return bridgeGame.move(MoveDirection.getMoveDirection(movingRoute));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Bridge getBridge() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return new Bridge(bridgeMaker.makeBridge(bridgeSize));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
