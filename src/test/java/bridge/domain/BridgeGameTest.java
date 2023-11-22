package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.MoveDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("정상적으로 다리에서 이동이 되는지 확인하는 테스트입니다.")
    void 다리_이동_성공_로직_테스트() {
        int bridgeSize = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        if (bridge.getWay(0).equals("U")) {
            Assertions.assertThat(bridgeGame.move(MoveDirection.UP)).isEqualTo(1);
        } else {
            Assertions.assertThat(bridgeGame.move(MoveDirection.DOWN)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("잘못된 길로 이동하는 경우를 테스트합니다.")
    void 다리_이동_실패_로직_테스트() {
        int bridgeSize = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        if (bridge.getWay(0).equals("U")) {
            Assertions.assertThat(bridgeGame.move(MoveDirection.DOWN)).isEqualTo(-1);
        } else {
            Assertions.assertThat(bridgeGame.move(MoveDirection.UP)).isEqualTo(-1);
        }
    }
}