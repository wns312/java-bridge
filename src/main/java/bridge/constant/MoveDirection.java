package bridge.constant;

import java.util.Arrays;

public enum MoveDirection {
    UP("U"),
    DOWN("D");

    private String direction;

    private MoveDirection(String direction) {
        this.direction = direction;
    }

    public static MoveDirection getMoveDirection(String direction) {
        return Arrays.stream(values())
                .filter(moveDirection -> moveDirection.getDirection().equals(direction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getDirection() {
        return direction;
    }
}
