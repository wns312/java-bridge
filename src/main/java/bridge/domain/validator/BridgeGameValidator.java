package bridge.domain.validator;

import bridge.domain.exception.IllegalArgumentExceptionType;
import bridge.domain.exception.IllegalStateExceptionType;

public class BridgeGameValidator {
    private static final String UP_SIGNATURE = "U";
    private static final String DOWN_SIGNATURE = "D";

    public static void validateMoveExpression(String moveInput) {
        if (!UP_SIGNATURE.equals(moveInput) && !DOWN_SIGNATURE.equals(moveInput)) {
            throw IllegalArgumentExceptionType.INVALID_MOVE_COMMAND.getException();
        }
    }

    public static void validateIsGameEnd(boolean isGameEnd) {
        if (isGameEnd) {
            throw IllegalStateExceptionType.INVALID_MOVING.getException();
        }
    }
}
