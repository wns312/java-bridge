package bridge.error;

public enum ErrorCode {
    INVALID_BRIDGE_LENGTH("유효하지 다리 길이입니다."),
    INVALID_BRIDGE_SIZE_TYPE("다리 길이에는 정수값이 들어와야 합니다."),
    INVALID_MOVING("유효하지 않은 이동 경로입니다."),
    INVALID_COMMAND("유효하지 않은 커맨드 값입니다.");


    private static final String MESSAGE_FORMAT = "[ERROR] %s";

    private String message;

    private ErrorCode(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
