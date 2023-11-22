package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final Map<Integer, String> bridgeMap = Map.of(
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
            bridge.add(bridgeMap.get(generatedNumber));

        }

        return bridge;
    }
}
