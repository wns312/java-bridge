package bridge.domain.constant;

import bridge.domain.exception.IllegalArgumentExceptionType;
import java.util.stream.Stream;

public enum BridgeMove {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String expression;

    BridgeMove(int number, String expression) {
        this.number = number;
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public boolean hasSameNumber(int number) {
        return this.number == number;
    }
    public boolean hasSameExpression(String expression) {
        return this.expression.equals(expression);
    }

    public static BridgeMove getByNumber(int number) {
        return Stream.of(values())
                .filter(bridgeMove -> bridgeMove.hasSameNumber(number))
                .findAny()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_MOVE_NUMBER::getException);
    }

    public static BridgeMove getByExpression(String expression) {
        return Stream.of(values())
                .filter(bridgeMove -> bridgeMove.hasSameExpression(expression))
                .findAny()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_MOVE_COMMAND::getException);
    }
}
