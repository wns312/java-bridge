package bridge.view;

import java.util.List;
import java.util.Map;

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

    public void printResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printResult(boolean isGameSucceeded, int retryCount) {
        System.out.printf(GAME_RESULT_EXPRESSION, RESULT_EXPRESSION_MATCHER.get(isGameSucceeded));
        System.out.printf(TRY_COUNT_EXPRESSION, retryCount);
    }

    public void printIntroMessage() {
        System.out.println(BRIDGE_SIZE_INPUT_INTRO_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
