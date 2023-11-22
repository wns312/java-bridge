package bridge.view;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_SIZE_INPUT_INTRO_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String GAME_RESULT_EXPRESSION = "%n%n게임 성공 여부: %s";
    private static final Map<Boolean, String> RESULT_EXPRESSION_MATCHER = Map.of(
            true, "성공",
            false, "실패"
    );
    private static final String TRY_COUNT_EXPRESSION = "%n총 시도한 횟수: %d";

    BridgeExpressionMaker bridgeExpressionMaker;

    public OutputView(BridgeExpressionMaker bridgeExpressionMaker) {
        this.bridgeExpressionMaker = bridgeExpressionMaker;
    }

    public void printMap(List<String> bridge, List<String> userBridge) {
        System.out.println(bridgeExpressionMaker.createBridgeExpression(bridge, userBridge));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printIntroMessage() {
        System.out.println(BRIDGE_SIZE_INPUT_INTRO_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
