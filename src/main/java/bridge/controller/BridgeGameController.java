package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeSize;
import bridge.domain.constant.BridgeMove;
import bridge.domain.constant.RetryCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printIntroMessage();
        BridgeSize bridgeSize = readBridgeSize();
        BridgeGame bridgeGame = createBridgeGame(bridgeSize);
        repeatedPlay(bridgeGame);
        printGameResult(bridgeGame);
    }

    private BridgeSize readBridgeSize() {
        return repeatBeforeSuccess(() -> new BridgeSize(inputView.readBridgeSize()));
    }

    private BridgeGame createBridgeGame(BridgeSize bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());

        return new BridgeGame(bridge);
    }

    private void repeatedPlay(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            play(bridgeGame);
            if (bridgeGame.isGameSucceeded()) {
                break;
            }
            confirmRetry(bridgeGame);
        }
    }

    private void confirmRetry(BridgeGame bridgeGame) {
        RetryCommand retryCommand = readRetryCommand();

        if (retryCommand.isRetry()) {
            bridgeGame.retry();
        }
    }

    private RetryCommand readRetryCommand() {
        return repeatBeforeSuccess(() -> RetryCommand.getCommandByExpression(inputView.readGameCommand()));
    }

    private void printGameResult(BridgeGame bridgeGame) {
        outputView.printResultMessage();
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserBridge());
        outputView.printResult(bridgeGame.isGameSucceeded(), bridgeGame.getTryCount());
    }

    private void play(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            move(bridgeGame);
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserBridge());
        }

    }

    private void move(BridgeGame bridgeGame) {
        repeatBeforeSuccess(() -> {
            String moveExpression = inputView.readMoving();
            BridgeMove bridgeMove = BridgeMove.getByExpression(moveExpression);
            return bridgeGame.move(bridgeMove);
        });
    }

    private <R> R repeatBeforeSuccess(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
