package bridge.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgePositionTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 2, 10})
    void 다리_위치_생성_로직_실패_테스트(int number) {
        assertThatThrownBy(() -> BridgePosition.getPosition(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위쪽 경로 다리 생성 로직을 테스트합니다.")
    void 위쪽_다리_생성_로직_테스트() {
        int number = 1;
        BridgePosition position = BridgePosition.getPosition(1);
        Assertions.assertThat(position.getPosition()).isEqualTo("U");
    }

    @Test
    @DisplayName("아래쪽 경로 다리 생성 로직을 테스트합니다.")
    void 아래쪽_다리_생성_로직_테스트() {
        int number = 0;
        BridgePosition position = BridgePosition.getPosition(0);
        Assertions.assertThat(position.getPosition()).isEqualTo("D");
    }


}