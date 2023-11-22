package bridge.domain;

import bridge.error.ErrorCode;
import java.util.List;

public class Bridge {
    List<String> spaces;

    public Bridge(List<String> spaces) {
        validateBridgeLength(spaces);
        this.spaces = spaces;
    }

    public String getWay(int index) {
        return spaces.get(index);
    }

    private void validateBridgeLength(List<String> spaces) {
        if (spaces.size() < 3 || spaces.size() > 20) {
            throw ErrorCode.INVALID_BRIDGE_LENGTH.getException();
        }
    }
}
