package bridge.view;

import java.util.ArrayList;
import java.util.List;

public class BridgeExpressionMaker {
    private static final String BRIDGE_START_EXPRESSION = "[ ";
    private static final String BRIDGE_END_EXPRESSION = " ]";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String BRIDGE_UP_EXPRESSION = "U";
    private static final String BRIDGE_DOWN_EXPRESSION = "D";
    private static final String BRIDGE_CORRECT_EXPRESSION = "O";
    private static final String BRIDGE_INCORRECT_EXPRESSION = "X";
    private static final String BRIDGE_EMPTY_EXPRESSION = " ";
    private static final String LINE_SEPARATOR = "\n";

    public String createBridgeExpression(List<String> bridge, List<String> userBridge) {
        List<String> upperBridgeExpressions = new ArrayList<>();
        List<String> lowerBridgeExpressions = new ArrayList<>();
        for (int i = 0; i < userBridge.size(); i++) {
            String bridgeExpression = bridge.get(i);
            String userBridgeExpression = userBridge.get(i);
            upperBridgeExpressions.add(createUpperBridgeExpression(bridgeExpression, userBridgeExpression));
            lowerBridgeExpressions.add(createLowerBridgeExpression(bridgeExpression, userBridgeExpression));
        }

        return createWholeBridgeExpression(upperBridgeExpressions, lowerBridgeExpressions);
    }

    private String createUpperBridgeExpression(String bridgeExpression, String userBridgeExpression) {
        if (bridgeExpression.equals(BRIDGE_DOWN_EXPRESSION)) {
            return BRIDGE_EMPTY_EXPRESSION;
        }

        return createBridgeCorrectiveExpression(bridgeExpression, userBridgeExpression);
    }

    private String createLowerBridgeExpression(String bridgeExpression, String userBridgeExpression) {
        if (bridgeExpression.equals(BRIDGE_UP_EXPRESSION)) {
            return BRIDGE_EMPTY_EXPRESSION;
        }

        return createBridgeCorrectiveExpression(bridgeExpression, userBridgeExpression);
    }

    private String createBridgeCorrectiveExpression(String bridgeExpression, String userBridgeExpression) {
        if (bridgeExpression.equals(userBridgeExpression)) {
            return BRIDGE_CORRECT_EXPRESSION;
        }

        return BRIDGE_INCORRECT_EXPRESSION;
    }

    private String createWholeBridgeExpression(List<String> upperBridgeExpressions, List<String> lowerBridgeExpressions) {
        return createSingleBridgeExpression(upperBridgeExpressions)
                + LINE_SEPARATOR
                + createSingleBridgeExpression(lowerBridgeExpressions);
    }

    private String createSingleBridgeExpression(List<String> bridgeExpressions) {
        return BRIDGE_START_EXPRESSION
                + String.join(BRIDGE_DELIMITER, bridgeExpressions)
                + BRIDGE_END_EXPRESSION;
    }
}
