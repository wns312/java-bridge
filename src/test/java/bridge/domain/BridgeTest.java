package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 25})
    void 유효하지_않은_다리_길이_테스트(int length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> new Bridge(bridgeMaker.makeBridge(length)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 15, 20})
    void 유효한_다리_길이_테스트(int length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        new Bridge(bridgeMaker.makeBridge(length));
    }
}