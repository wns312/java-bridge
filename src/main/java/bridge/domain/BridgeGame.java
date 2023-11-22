package bridge.domain;

import bridge.constant.MoveDirection;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
