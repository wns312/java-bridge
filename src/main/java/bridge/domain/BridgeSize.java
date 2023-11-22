package bridge.domain;

import bridge.domain.exception.IllegalArgumentExceptionType;

public class BridgeSize {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private final int size;

    public BridgeSize(int size) {
        validateMinRange(size);
        validateMaxRange(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void validateMinRange(int size) {
        if (size < MIN_BRIDGE_SIZE) {
            throw IllegalArgumentExceptionType.INVALID_BRIDGE_LENGTH.getException();
        }
    }

    private void validateMaxRange(int size) {
        if (size > MAX_BRIDGE_SIZE) {
            throw IllegalArgumentExceptionType.INVALID_BRIDGE_LENGTH.getException();
        }
    }
}
