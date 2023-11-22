package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.domain.constant.BridgeMove;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generatedNumber = bridgeNumberGenerator.generate();
            BridgeMove bridgeMove = BridgeMove.getByNumber(generatedNumber);
            bridge.add(bridgeMove.getExpression());
        }

        return bridge;
    }
}
