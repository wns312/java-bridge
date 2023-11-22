package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BridgeMaker {
    private static final Map<Integer, String> BRIDGE_MAP = Map.of(
            0, "D",
            1, "U"
    );

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generatedNumber = bridgeNumberGenerator.generate();
            bridge.add(BRIDGE_MAP.get(generatedNumber));

        }

        return bridge;
    }
}
