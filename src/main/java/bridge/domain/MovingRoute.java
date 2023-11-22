package bridge.domain;

import bridge.constant.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class MovingRoute {
    private List<String> route;
    private final Bridge bridge;

    public MovingRoute(Bridge bridge) {
        this.bridge = bridge;
        route = new ArrayList<>();
    }

    public String getRouteByIndex(int index) {
        return route.get(index);
    }

    public String getBridgePositionByIndex(int index) {
        return bridge.getWay(index);
    }

    public int getCurrentPosition() {
        return route.size();
    }

    public void recordSuccessMove(MoveDirection moveDirection) {
        if (moveDirection == MoveDirection.UP) {
            route.add(MoveDirection.UP.getDirection());
            return;
        }
        route.add(MoveDirection.DOWN.getDirection());
    }

    public void recordFailMove(MoveDirection moveDirection) {
        if (moveDirection == MoveDirection.UP) {
            route.add(MoveDirection.DOWN.getDirection());
            return;
        }
        route.add(MoveDirection.UP.getDirection());
    }
}
