package bridge.domain;

import bridge.error.ErrorCode;
import java.util.List;

public class Bridge {
    private final int BRIDGE_MIN_SIZE = 3;
    private final int BRIDGE_MAX_SIZE = 20;

    List<String> spaces;

    public Bridge(List<String> spaces) {
        validateBridgeLength(spaces);
        this.spaces = spaces;
    }

    public String getWay(int index) {
        return spaces.get(index);
    }

    public int getBridgeSize() {
        return spaces.size();
    }

    private void validateBridgeLength(List<String> spaces) {
        if (spaces.size() < BRIDGE_MIN_SIZE || spaces.size() > BRIDGE_MAX_SIZE) {
            throw ErrorCode.INVALID_BRIDGE_LENGTH.getException();
        }
    }
}
