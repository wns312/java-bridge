package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeSize;
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
    }

    private BridgeGame createBridgeGame(BridgeSize bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        return new BridgeGame(bridge);

    }

    private BridgeSize readBridgeSize() {
        return repeatBeforeSuccess(() -> new BridgeSize(inputView.readBridgeSize()));
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
