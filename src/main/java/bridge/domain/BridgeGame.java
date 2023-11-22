package bridge.domain;

import bridge.constant.MoveDirection;

public class BridgeGame {
    private final Bridge bridge;
    private int position;
    private MovingRoute movingRoute;
    private int tryCount;

    public BridgeGame(Bridge bridge) {
        position = 0;
        tryCount = 1;
        this.bridge = bridge;
        movingRoute = new MovingRoute(bridge);
    }

    public int move(MoveDirection moveDirection) {
        if (moveDirection.getDirection() == bridge.getWay(position)) {
            movingRoute.recordSuccessMove(moveDirection);
            position++;
            return position;
        }
        movingRoute.recordFailMove(moveDirection);
        position++;
        return -1;
    }

    public MovingRoute getMovingRoute() {
        return movingRoute;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void retry() {
        position = 0;
        movingRoute = new MovingRoute(bridge);
        tryCount++;
    }

    public boolean isSuccess() {
        if (position == bridge.getBridgeSize()) {
            return true;
        }
        return false;
    }
}
