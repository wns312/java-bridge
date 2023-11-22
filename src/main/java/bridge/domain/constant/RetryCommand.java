package bridge.domain.constant;

import bridge.domain.exception.IllegalArgumentExceptionType;
import java.util.stream.Stream;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String expression;

    RetryCommand(String expression) {
        this.expression = expression;
    }

    private boolean hasSameExpression(String expression) {
        return this.expression.equals(expression);
    }

    public boolean isRetry() {
        return this == RETRY;
    }

    public static RetryCommand getCommandByExpression(String expression) {
        return Stream.of(values())
                .filter(retryCommand -> retryCommand.hasSameExpression(expression))
                .findAny()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_RETRY_COMMAND::getException);

    }
}
