package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printIntroMessage();
        BridgeSize bridgeSize = readBridgeSize();

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
