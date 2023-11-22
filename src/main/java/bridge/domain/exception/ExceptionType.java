package bridge.domain.exception;

public interface ExceptionType<T> {
    static final String ERROR_PREFIX = "[ERROR] ";

    String getMessage();

    T getException();
}
