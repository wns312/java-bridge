package bridge.domain;

import bridge.domain.validator.BridgeGameValidator;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private List<String> userBridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        userBridge = new ArrayList<>();
        tryCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserBridge() {
        return userBridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    private boolean isMoveSucceeded() { return !isGameFailed(); }

    public boolean isGameFailed() {
        if (userBridge.isEmpty()) {
            return false;
        }

        int lastUserBridgeIdx = userBridge.size() - 1;
        String lastUserMove = userBridge.get(lastUserBridgeIdx);

        return !lastUserMove.equals(bridge.get(lastUserBridgeIdx));
    }

    public boolean isGameSucceeded() {
        return userBridge.size() == bridge.size() && !isGameFailed();
    }

    public boolean isGameEnd() { return isGameSucceeded() || isGameFailed(); }

    public boolean move(String moveExpression) {
        BridgeGameValidator.validateMoveExpression(moveExpression);
        BridgeGameValidator.validateIsGameEnd(isGameEnd());
        userBridge.add(moveExpression);

        return isMoveSucceeded();
    }

    public void retry() {
        userBridge = new ArrayList<>();
        tryCount++;
    }
}
