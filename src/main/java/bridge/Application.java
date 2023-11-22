package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, bridgeMaker);

        bridgeGameController.run();
    }
}
