package bridge.domain.exception;

public interface ExceptionType<T> {
    String ERROR_PREFIX = "[ERROR] ";

    String getMessage();
    T getException();
}
