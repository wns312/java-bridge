package bridge.domain.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVE_COMMAND("올바른 이동 문자가 아닙니다."),
    INVALID_RETRY_COMMAND("올바른 재시도 입력 문자가 아닙니다.");
    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = ERROR_PREFIX + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
