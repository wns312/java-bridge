package bridge.domain.exception;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException> {
    INVALID_MOVING("게임이 종료되어 이동할 수 없습니다.");

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = ERROR_PREFIX + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException(getMessage());
    }
}
