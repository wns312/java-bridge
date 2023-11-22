package bridge.domain.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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
